import java.io.*;
import java.util.*;


class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int n, m;
    static int[][] map;
    static int[][] psum_map;

    static void print2darr() {
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n; j++) {
                System.out.print(psum_map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void getAllPsum() {
        for (int i = 0 ; i < n; i ++) {
            for (int j = 0 ; j < n ; j++) {
                psum_map[i][j] += map[i][j];

                if (i-1 >= 0) {
                    psum_map[i][j] += psum_map[i-1][j];
                }
                
                if (j-1 >= 0) {
                    psum_map[i][j] += psum_map[i][j-1];
                }

                if (i-1 >= 0 && j-1 >= 0) {
                    psum_map[i][j] -= psum_map[i-1][j-1];
                }
            }
        }
    }

    static int getPsum(int x1, int x2, int y1, int y2) {
        int sum = psum_map[x2][y2];

        if (x1-1 >= 0) {
            sum -= psum_map[x1-1][y2];
        }
                
        if (y1-1 >= 0) {
            sum -= psum_map[x2][y1-1];
        }

        if (x1-1 >= 0 && y1-1 >= 0) {
            sum += psum_map[x1-1][y1-1];
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        str = new StringTokenizer(buffer.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        map = new int[n][n];
        psum_map = new int[n][n];

        for (int i = 0 ; i < n ; i ++) {
            str = new StringTokenizer(buffer.readLine());
            for (int j = 0 ; j < n ; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        getAllPsum();
        // print2darr();

        for (int i = 0 ; i < m ; i++) {
            int x1, x2, y1, y2;

            str = new StringTokenizer(buffer.readLine());

            x1 = Integer.parseInt(str.nextToken());
            y1 = Integer.parseInt(str.nextToken());
            x2 = Integer.parseInt(str.nextToken());
            y2 = Integer.parseInt(str.nextToken());

            System.out.println(getPsum(x1-1, x2-1, y1-1, y2-1));
        }
    }
}