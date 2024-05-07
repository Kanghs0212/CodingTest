import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int point;
    int cost;

    public Node(int index, int cost) {
        this.point = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int V,E;
    static boolean[] check;
    static PriorityQueue<Node> Q = new PriorityQueue<>();

    public static void dijkstra(int start){
        for (int i = 1; i <V+1 ; i++) {
            dist[i]= Integer.MAX_VALUE;
        }
        dist[start]=0;
        Q.offer(new Node(start, 0));

        while(!Q.isEmpty()){
            Node cur = Q.poll();
            if(check[cur.point]) continue;
            check[cur.point]=true;
            for (Node next: graph[cur.point]){
                if(dist[next.point]>next.cost+dist[cur.point]){
                    dist[next.point]= next.cost+dist[cur.point];
                    Q.offer(new Node(next.point, dist[next.point]));
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        dist = new int[V+1];
        check = new boolean[V+1];
        for (int i = 0; i <V+1 ; i++) {
            graph[i]= new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[first].add(new Node(second, cost));
            graph[second].add(new Node(first, cost));
        }

        dijkstra(1);
        System.out.println(dist[V]);

    }
}