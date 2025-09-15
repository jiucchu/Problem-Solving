import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int t, n;
    static String[] st;
    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(buffer.readLine());
        for (int tc = 1 ; tc < t + 1 ; tc++) {
            n = Integer.parseInt(buffer.readLine());

            st = new String[n];
            str = new StringTokenizer(buffer.readLine());
            
            for (int i = 0 ; i < n ; i++){
                st[i] = str.nextToken();
            }

            System.out.print("#" + tc + " ");
            for (int i = 0 ; i < n ; i ++) {
                if (i % 2 == 0) {
                    System.out.print(st[i / 2] + " ");
                } else {
                    System.out.print(st[(n+1)/2 + (i / 2)] + " ");
                }
            }
            System.out.println();
        }
    }
}
