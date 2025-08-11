
import java.io.*;
import java.util.*;

public class Solution{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int t, n, ans;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = { 0, 0,-1, 1};

    // 블록 1번부터 5번까지 반사
    static int[][] reflect = {
        {0,0,0,0},  
        {1,3,0,2}, 
        {3,0,1,2},  
        {2,0,3,1}, 
        {1,2,3,0},  
        {1,0,3,2} 
    };

    static ArrayList<int[]>[] worm;
    
    static int simulate(int sx, int sy, int d) {
        int count = 0;
        int x = sx;
        int y = sy;

        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                d = reflect[5][d];
                count++;
                x = nx;
                y = ny;
                continue;
            }

            // System.out.println(nx + " " + ny);
           
            int now = map[nx][ny];

            if (now == -1 || (nx == sx && ny == sy)) {
                return count;
            }

            if (now == 0) {
                x = nx;
                y = ny;
                continue;
            }

            if (1 <= now && now <= 5) {
                d = reflect[now][d];
                count++;
                x = nx;
                y = ny;
                continue;
            }

            if (now >= 6) {
                int[] a = worm[now].get(0);
                int[] b = worm[now].get(1);
                if (nx == a[0] && ny == a[1]){ 
                    x = b[0];
                    y = b[1]; 
                } else {
                    x = a[0];
                    y = a[1];
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            map = new int[n][n];

            worm = new ArrayList[11];
            for (int k = 0; k <= 10; k++) worm[k] = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    int k = Integer.parseInt(st.nextToken());
                    map[i][j] = k;
                    if (k >= 6) worm[k].add(new int[]{i, j});
                }
            }

            ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0){
                        continue;
                    }
                    for (int d = 0; d < 4; d++) {
                        ans = Math.max(ans, simulate(i, j, d));
                    }
                    
                }
                // break;
            }

            System.out.println("#" + tc + " " + ans);
        }
    }

}
