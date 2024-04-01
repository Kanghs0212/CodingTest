import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static class Node{
        int point, weight;

        public Node(int point, int weight){
            this.point=point;
            this.weight=weight;
        }
    }
    static List<Node>[] list;
    static int[][] result;

    public static void djikstra(int start){
        boolean[] check = new boolean[N+1];
        int[] dist = new int[N+1];
        PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2)-> o1.weight - o2.weight);
        for (int i = 1; i <= N; i++) {
            dist[i]=Integer.MAX_VALUE;
        }

        dist[start]=0;
        Q.offer(new Node(start, 0));

        while (!Q.isEmpty()){
            Node now = Q.poll();

            if(dist[now.point]<now.weight) continue;
            if(!check[now.point]) check[now.point]=true;
            for (int i = 0; i < list[now.point].size(); i++) {
                Node nxt = list[now.point].get(i);

                if(!check[nxt.point] && now.weight + nxt.weight < dist[nxt.point]){
                    dist[nxt.point]= now.weight + nxt.weight;
                    result[nxt.point-1][start-1]=now.point;
                    Q.add(new Node(nxt.point, dist[nxt.point]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[N][N];
        list = new List[N+1];
        for (int i = 1; i <= N; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int weight= Integer.parseInt(st.nextToken());
            list[first].add(new Node(second, weight));
            list[second].add(new Node(first, weight));
        }

        for (int i = 1; i <= N; i++) {
            djikstra(i);
        }
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==j) SB.append("- ");
                else
                    SB.append(result[i][j]).append(" ");
            }
            SB.append("\n");
        }
        System.out.println(SB);
    }
}