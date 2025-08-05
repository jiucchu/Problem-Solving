import java.io.*;
import java.util.*;

class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int n, answer;
    static int[] numbers;
    static int[] nsum;
    public static void main(String[] args) throws IOException {
        // 코드 작성

        n = Integer.parseInt(buffer.readLine());
        str = new StringTokenizer(buffer.readLine());
        answer = 0;

        numbers = new int[n];
        nsum = new int[n];
        for (int i = 0 ; i < n ; i++) {
            numbers[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(numbers);

        for (int i = 1; i < n; i++) {
            nsum[i] = numbers[i] + numbers[i-1];
        }

        
        for (int i = 1; i < n ; i++) {
            for (int j = n-1; j >= i ; j--) {
                // System.out.println(nsum[i] + " " + numbers[j]);
                if (nsum[i] > numbers[j]){
                    // System.out.println(j-i+2);
                    answer = Math.max(answer, j-i+2);
                }
            }
        }

        if (n==1) {
            answer = 1;
        }

        System.out.println(answer);
    }
}