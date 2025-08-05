import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;

    // 육각형 이동: 짝수 행과 홀수 행이 다름
    static int[] dxEven = {-1, -1, 0, 0, 1, 1};
    static int[] dyEven = {-1, 0, -1, 1, -1, 0};
    static int[] dxOdd  = {-1, -1, 0, 0, 1, 1};
    static int[] dyOdd  = {0, 1, -1, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(buffer.readLine());

        w = Integer.parseInt(str.nextToken());
        h = Integer.parseInt(str.nextToken());

        // padding 포함해서 배열 생성
        map = new int[h + 2][w + 2];
        visited = new boolean[h + 2][w + 2];

        for (int i = 1; i <= h; i++) {
            str = new StringTokenizer(buffer.readLine());
            for (int j = 1; j <= w; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        // 1. 외부 공기 영역 탐색 (0,0)에서 시작
        markOutsideAir(0, 0);

        // 2. 내부 공기 영역(map == 0 && !visited) → 벽(1)으로 간주
        for (int i = 0; i < h + 2; i++) {
            for (int j = 0; j < w + 2; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    map[i][j] = 1;
                }
            }
        }

        // 3. 둘레 계산
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (map[i][j] == 1) {
                    countPerimeter(i, j);
                }
            }
        }

        // 4. 출력
        System.out.println(answer);
    }

    // 외부 공기 flood fill
    static void markOutsideAir(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            int[] dx = (cx % 2 == 0) ? dxEven : dxOdd;
            int[] dy = (cx % 2 == 0) ? dyEven : dyOdd;

            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    // 벽 하나의 외부 둘레 계산
    static void countPerimeter(int x, int y) {
        int[] dx = (x % 2 == 0) ? dxEven : dxOdd;
        int[] dy = (x % 2 == 0) ? dyEven : dyOdd;

        for (int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 외부 공기거나 격자 밖이면 둘레로 간주
            if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2 || map[nx][ny] == 0) {
                answer++;
            }
        }
    }
}
