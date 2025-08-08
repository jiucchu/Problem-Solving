import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int n, m;
    static Queue<Integer> q = new LinkedList<>();
    static int[] topology;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    static void topology_sort() {
        while(!q.isEmpty()) {
            int s = q.poll();
            sb.append(s);
            sb.append(" ");

            graph[s].forEach((node) -> {
                topology[node]--;

                if (topology[node] == 0) {
                    q.add(node);
                }
            });
        }
    }

    public static void main(String[] args)  throws IOException{
        str = new StringTokenizer(buffer.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());

        topology = new int[n+1];
        graph = new ArrayList[n+1];
        for (int i = 0; i < n+1 ; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 및 진입 차수 갱신
        for (int i = 0 ; i < m ; i++) {
            str = new StringTokenizer(buffer.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            graph[a].add(b);
            topology[b]++;
        }

        for (int i = 1 ; i < n+1 ; i++) {
            if (topology[i] == 0) {
                q.add(i);
            }
        }
        topology_sort();
        System.out.println(sb);
    }
}
