import java.io.*;
import java.util.*;

class Main {

    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer str;
    static HashMap<String, String[]> graph = new HashMap<>();
    static int n;
    static StringBuilder preSB = new StringBuilder();
    static StringBuilder inSB = new StringBuilder();
    static StringBuilder postSB = new StringBuilder();
    
    public static void pre(String node) {
        preSB.append(node);
        String[] child = graph.get(node);

        if (!child[0].equals(".")) {
            pre(child[0]);
        }

        if (!child[1].equals(".")) {
            pre(child[1]);
        }
    }

    public static void in(String node) {
        String[] child = graph.get(node);

        if (!child[0].equals(".")) {
            in(child[0]);
        }

        inSB.append(node);

        if (!child[1].equals(".")) {
            in(child[1]);
        }

        
    }

    public static void post(String node) {
        String[] child = graph.get(node);

        if (!child[0].equals(".")) {
            post(child[0]);
        }

        
        if (!child[1].equals(".")) {
            post(child[1]);
        }

        postSB.append(node);
    }

    public static void main(String[] args) throws IOException {
        // 그래프 생성
        n = Integer.parseInt(buffer.readLine());
        for (int i = 0 ; i < n ; i++) {
            str = new StringTokenizer(buffer.readLine());
            String node = str.nextToken();
            String left = str.nextToken();
            String right = str.nextToken();

            graph.put(node, new String[] {left, right});

        }

        // graph.entrySet().forEach(entry -> {
        //     System.out.println(entry.getKey());
        //     for (String i : entry.getValue()) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // });

        pre((String)"A");
        in((String)"A");
        post((String)"A");
        System.out.println(preSB);
        System.out.println(inSB);
        System.out.println(postSB);
        
    }
}