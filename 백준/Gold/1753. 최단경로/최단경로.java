import java.util.*;
import java.io.*;

public class Main {
    static int V,E;
    static class Pair{
        int i, cost;
        public Pair(int i, int cost){
            this.i=i;
            this.cost=cost;
        }
    }
    static PriorityQueue<Pair> Q = new PriorityQueue<Pair>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    static ArrayList<ArrayList<Pair>> graph = new ArrayList<ArrayList<Pair>>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        dist = new int[V+1];
        for (int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= V; i++) {
            dist[i]=Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Pair(e,cost));
        }

        Q.add(new Pair(start,0));
        dist[start]=0;

        while (!Q.isEmpty()){
            Pair cur = Q.poll();

            for (int i = 0; i < graph.get(cur.i).size(); i++) {
                Pair nxt = graph.get(cur.i).get(i);
                if(dist[nxt.i]<cur.cost)
                    continue;
                if(dist[nxt.i]>dist[cur.i]+nxt.cost){
                    dist[nxt.i]=dist[cur.i]+nxt.cost;

                    Q.add(new Pair(nxt.i, dist[nxt.i]));
                }
            }
        }
        StringBuilder SB = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(dist[i]==Integer.MAX_VALUE)
                SB.append("INF\n");
            else
                SB.append(dist[i]).append("\n");
        }
        bw.write(SB.toString());
        br.close();
        bw.close();
    }
}