import java.io.*;
import java.util.*;

class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int n, m;
    static int[] numbers, psum;
    public static void main(String[] args) throws IOException {
        str = new StringTokenizer(buffer.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        numbers = new int[n+1];
        psum = new int[n+1];

        str = new StringTokenizer(buffer.readLine());
        for (int i = 1 ; i < n+1; i++) {
            numbers[i] = Integer.parseInt(str.nextToken());
        }

        for (int i = 1; i < n+1; i++) {
            psum[i] = numbers[i] + psum[i-1];
        }

        for (int i = 0 ; i < m ; i++) {
            str = new StringTokenizer(buffer.readLine());
            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());

            System.out.println(psum[e] - psum[s-1]);
        }

        
    }
}