import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int p, cost;

        public Node(int p, int cost){
            this.p=p;
            this.cost=cost;
        }
    }

    static int V,E;
    static ArrayList<Node>[] map;
    static PriorityQueue<Node> Q = new PriorityQueue<>((Node o1, Node o2)-> o1.cost -o2.cost);
    static int[] dist;
    public static void Dijkstra(int start){
        dist[start]=0;
        Q.offer(new Node(start, 0));

        while (!Q.isEmpty()){
            Node cur = Q.poll();

            if(dist[cur.p]<cur.cost)
                continue;

            for (int i = 0; i < map[cur.p].size() ; i++) {
                Node nxt = map[cur.p].get(i);
                if(dist[nxt.p]>nxt.cost + dist[cur.p]){
                    dist[nxt.p] = nxt.cost + dist[cur.p];
                    Q.offer(new Node(nxt.p, dist[nxt.p]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        V=Integer.parseInt(br.readLine());
        E=Integer.parseInt(br.readLine());
        map = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            map[i]=new ArrayList<>();
        }
        dist = new int[V+1];
        for (int i = 0; i <= V; i++) {
            dist[i]=Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[first].add(new Node(second,cost));
        }

        st=new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(start);
        System.out.println(dist[end]);

    }
}