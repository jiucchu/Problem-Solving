import java.io.*;
import java.util.*;


class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int n , m;
    static ArrayList<Integer>[] graph;
    static int max;
    static int[] visited;
    static int[] trusts;

    static void bfs(int num) {
        Queue<Integer> q = new ArrayDeque<>();
        // int temp = 0;
        q.add(num);
        visited[num] = 1;

        while(!q.isEmpty()) {
            int s = q.poll();

            for (int i : graph[s]){
                if (visited[i] == 0) {
                    trusts[i]++;
                    visited[i] = 1;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        str = new StringTokenizer(buffer.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        graph = new ArrayList[n+1];
        for (int i=0; i<n+1; i++) graph[i] = new ArrayList <Integer>();
        trusts = new int[n+1];
        max = 0;

        for (int i = 0 ; i < m ; i++) {
            str = new StringTokenizer(buffer.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            graph[a].add(b);
        }

        for (int i = 0 ; i < n ; i++) {
            visited = new int[n+1];
            bfs(i+1);
        }

        for (int i = 1; i < n+1; i++) {
            max = Math.max(max, trusts[i]);
        }

        for (int i = 1; i < n+1; i++) {
            if (trusts[i] == max) {
                System.out.print(i+" ");
            }
            
        }
    }
}