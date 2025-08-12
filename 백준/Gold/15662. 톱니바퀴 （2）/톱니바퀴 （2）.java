import java.io.*;
import java.util.*;

class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
     

    static int n, m;
    static int[][] map;

    static void print2darr(int[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0 ; j < arr[0].length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }
    static void run_chain(int t, int k, int isPositive) {
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {t, isPositive});
        visited[t] = true;

        if (k == 0) {return;}

        while(!q.isEmpty()) {
            int[] s = q.poll();

            int idx = s[0];
            int d = s[1];

            if ((idx - 1 >= 1) && (map[idx][6] != map[idx-1][2])) {
                if (!visited[idx-1]) {
                    q.add(new int[] {idx-1, -d});
                    visited[idx-1] = true;
                }
            } 

            if ((idx + 1 < n+1) && (map[idx][2] != map[idx+1][6])){
                if (!visited[idx+1]) {
                    q.add(new int[] {idx+1, -d});
                    visited[idx+1] = true;
                }
            }

            rotation(idx, d);
        }

        run_chain(t, k-1, isPositive);
    }

    static void rotation(int idx, int isPositive) {
        // System.out.println(idx + " " + isPositive);
        if (isPositive < 0) {
            int temp = map[idx][0];
            for (int i = 0; i < 7; i++) {
                map[idx][i] = map[idx][i+1];
            }
            map[idx][7] = temp;
        } else {
            int temp = map[idx][7];
            for (int i = 7; i > 0; i--) {
                map[idx][i] = map[idx][i-1];
            }
            map[idx][0] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(buffer.readLine());
        map = new int[n+1][8];
        
        for (int i = 1 ; i < n+1 ; i++) {
            char[] s = buffer.readLine().toCharArray();

            for (int j = 0 ; j < 8 ; j++) {
                map[i][j] = (int)(s[j]-'0');
            }
        }

        // print2darr(map);

        m = Integer.parseInt(buffer.readLine());
        for (int i = 0 ; i < m ; i++) {
            str = new StringTokenizer(buffer.readLine());
            int idx = Integer.parseInt(str.nextToken());
            int direction = Integer.parseInt(str.nextToken());

            run_chain(idx, Math.abs(direction), (direction > 0) ? 1 : -1);
            // print2darr(map);
        }

        int answer = 0;
        for (int i = 1; i < n+1 ; i++) {
            if (map[i][0] == 1) {answer++;}
        }
        System.out.println(answer);
    }
}