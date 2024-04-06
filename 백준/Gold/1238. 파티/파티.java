import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int p,cost;

        public Node(int p,int cost){
            this.p=p;
            this.cost=cost;
        }

    }
    static int V,E;
    static int[] dist;
    static boolean[] check;
    static ArrayList<ArrayList<Node>> point = new ArrayList<>();
    static ArrayList<ArrayList<Node>> point1 = new ArrayList<>();
    static PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

    public static void Dijikstra(int start){
        dist[start]=0;
        Q.offer(new Node(start,0));

        while (!Q.isEmpty()){
            Node cur = Q.poll();

            if(!check[cur.p])
                check[cur.p]=true;

            if(dist[cur.p] < cur.cost)
                continue;

            for (int i = 0; i < point.get(cur.p).size(); i++) {
                Node nxt = point.get(cur.p).get(i);

                if(!check[nxt.p] &&  dist[nxt.p]>nxt.cost+dist[cur.p]){
                    dist[nxt.p]=nxt.cost+dist[cur.p];
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
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        dist=new int[V+1];
        for (int i = 1; i <=V ; i++) {
            dist[i]=Integer.MAX_VALUE;
        }
        check=new boolean[V+1];
        int[] ans = new int[V+1];

        for (int i = 0; i <= V; i++) {
            point.add(new ArrayList<>());
            point1.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(st.nextToken());
            int sec =Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            point1.get(fir).add(new Node(sec, cost));
            //거꾸로 놓아서 다른 노드들이 해당 노드들에 가는 가중치를 구하도록함
            point.get(sec).add(new Node(fir, cost));
        }

        Dijikstra(start);
        for (int i = 1; i <= V; i++) {
            ans[i]+=dist[i];
        }
        for (int i = 1; i <=V ; i++) {
            dist[i]=Integer.MAX_VALUE;
        }

        point=point1;
        check=new boolean[V+1];
        Dijikstra(start);
        for (int i = 1; i < V+1; i++) {
            ans[i]+=dist[i];
        }

        Arrays.sort(ans);
        System.out.println(ans[V]);

    }
}