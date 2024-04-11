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
    static int V,E, bound;
    static int[] item;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static PriorityQueue<Node> Q = new PriorityQueue<>((Node o1, Node o2)-> (o1.cost - o2.cost));

    public static void Dijkstra(int start){
        Q.offer(new Node(start, 0));
        dist[start]=0;

        while (!Q.isEmpty()){
            Node cur = Q.poll();
            if(dist[cur.p]<cur.cost)
                continue;

            for (int i = 0; i < graph[cur.p].size(); i++) {
                Node nxt = graph[cur.p].get(i);
                if(dist[nxt.p]> dist[cur.p]+nxt.cost){
                    dist[nxt.p]= dist[cur.p]+nxt.cost;
                    Q.offer(new Node(nxt.p, dist[nxt.p]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        bound = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        item = new int[V+1];
        graph = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            graph[i]=new ArrayList<>();
        }

        st=new StringTokenizer(br.readLine());
        for (int i = 1; i <=V ; i++) {
            item[i]=Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[first].add(new Node(second,cost));
            graph[second].add(new Node(first, cost));
        }
        int max=Integer.MIN_VALUE;
        for (int i = 1; i <=V ; i++) {
            int sum=0;
            dist = new int[V+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Dijkstra(i);
            for (int j = 1; j <= V ; j++) {
                if(dist[j]<=bound){
                    sum+=item[j];
                }
            }
            if(sum>max)
                max=sum;
        }
        System.out.println(max);

    }
}