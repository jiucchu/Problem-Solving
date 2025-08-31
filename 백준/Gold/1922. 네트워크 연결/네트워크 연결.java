import java.io.*;
import java.util.*;



class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static int n, m;
    static List<Edge>[] graph;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static boolean[] visited;

    static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int prim(int s) {
        int cost = 0;
        visited[s] = true;

        for (Edge e : graph[s]) {
            pq.add(e);
        }
        
        while(!pq.isEmpty()){
            Edge pop = pq.poll();

            if(!visited[pop.node]){
                cost += pop.weight;
                visited[pop.node] = true;

                for (Edge e : graph[pop.node]){
                    pq.add(e);
                }
            }
        }

        return cost;

    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(buffer.readLine());
        m = Integer.parseInt(buffer.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0 ; i < n+1 ; i++) {graph[i] = new ArrayList<>();}

        visited = new boolean[n+1];

        for (int i = 0; i < m ; i++) {
            str = new StringTokenizer(buffer.readLine());

            int s = Integer.parseInt(str.nextToken());
            int e = Integer.parseInt(str.nextToken());
            int w = Integer.parseInt(str.nextToken());

            graph[s].add(new Edge(e, w));
            graph[e].add(new Edge(s, w));
        }

        System.out.println(prim(1));
    }
}