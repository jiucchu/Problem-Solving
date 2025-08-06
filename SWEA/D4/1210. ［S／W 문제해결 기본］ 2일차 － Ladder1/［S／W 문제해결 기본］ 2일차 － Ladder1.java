
import java.io.*;
import java.util.*;


public class Solution {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int[][] map;
    static int[][] visited;
    static int t, start;
    static int answer;

    static void print2darr() {
        for (int i = 0; i < 101; i++) {
            for (int j = 0 ; j < 101 ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void move(int x, int y) {
        
        if (x==1) {
            answer = y-1;
            return;
        }

        visited[x][y] = 1;

        int[] dx = {0, 0, -1};
        int[] dy = {1, -1, 0};

        for (int i = 0 ; i < 3 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > 100 || ny < 1 || ny > 100 || map[nx][ny] == 0 || visited[nx][ny] == 1){
                continue;
            } else {
                move(nx, ny);
                return;
            }
        }

    }
    public static void main(String[] args) throws IOException{

        for (int te = 0 ; te < 10; te++) {
            t = Integer.parseInt(buffer.readLine());
            map = new int[101][101];
            visited = new int[101][101];

            for(int i = 1; i < 101; i++) {
                str = new StringTokenizer(buffer.readLine());
                for (int j = 1 ; j < 101 ; j++){
                    int num = Integer.parseInt(str.nextToken());
                    map[i][j] = num;
                    if(i==100 && num == 2) {
                        start = j;
                    }
                }
            } 

            move(100, start);
            // print2darr();
            System.out.println("#" + t + " " + answer);
            }
    
    }
}
