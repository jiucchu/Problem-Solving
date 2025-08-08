import java.io.*;
import java.util.*;

class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int n;
    static int[][] foods;
    static int min, answer;

    static void getFood(int idx, int sour, int bitter) {
        int new_sour = sour * foods[idx][0];
        int new_bitter = bitter + foods[idx][1];

        int temp = Math.abs((new_sour) - (new_bitter));
        // System.out.println(new_sour+ " " + new_bitter);
        min = Math.min(min, temp);

        for (int i = idx+1; i < n; i++) {
            getFood(i, new_sour, new_bitter);
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(buffer.readLine());
        foods = new int[n][2];
        min = Integer.MAX_VALUE;
        for (int i = 0 ; i < n ; i++) {
            str = new StringTokenizer(buffer.readLine());
            foods[i][0] = Integer.parseInt(str.nextToken());
            foods[i][1] = Integer.parseInt(str.nextToken());
        }

        for (int i = 0 ; i < n ; i++) {
            getFood(i, 1, 0);
        }

        System.out.println(min);
    }
}