import java.io.*;
import java.util.*;

class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int n, m;
    static int[][] candies;
    static int answer;


    static int line_dp(int[] arr, int len){
        int dp[] = new int[len];

        for (int i = 0 ; i < len ; i++) {
            if (i<2) {
                dp[i] = arr[i];
            }
            
            if (i==2){
                dp[i] = arr[0] + arr[2];
            }

            if (i>2) {
                dp[i] = Math.max(Math.max(arr[i]+dp[i-3], arr[i]+dp[i-2]), dp[i-1]);
            }
            // System.out.print(dp[i]+" ");
        }
        // System.out.println("\n");
        return Arrays.stream(dp).max().getAsInt();
    }

    static boolean is_all_zero(int[][] arr) {
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (arr[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {

        while (true){
            str = new StringTokenizer(buffer.readLine());
            n = Integer.parseInt(str.nextToken());
            m = Integer.parseInt(str.nextToken());
            answer = 0;

            if (n==0 && m == 0){
                break;
            }

            candies = new int[n][m];
            
            for (int i = 0; i < n; i++) {
                str = new StringTokenizer(buffer.readLine());
                for (int j = 0; j < m; j++) {
                    candies[i][j] = Integer.parseInt(str.nextToken());
                }
            }

            int[] line_max = new int[n];
            for (int i = 0; i < n ; i++) {
                line_max[i] = line_dp(candies[i], m);
            }

            answer = line_dp(line_max, n);

            System.out.println(answer);
        }
    }
}