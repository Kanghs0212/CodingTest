import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int index,time;

        public Pair(int index, int time){
            this.index=index;
            this.time=time;
        }
    }
    static Queue<Integer> Q = new LinkedList<>();
    static int[] in;
    static int[] co;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        in = new int[N+1];
        co = new int[N+1];
        int[] time = new int[N+1];

        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i]=new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st=new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            in[i]=K;
            co[i]=cost;
            time[i]=cost;

            for (int j = 0; j < K; j++) {
                int second = Integer.parseInt(st.nextToken());
                graph[second].add(i);
            }
            if(K==0){
                Q.offer(i);
            }
        }
        int best = -1;
        while (!Q.isEmpty()){
            int cur= Q.poll();

            for (int i = 0; i < graph[cur].size(); i++) {
                int nxt = graph[cur].get(i);
                in[nxt]--;
                time[nxt]= Math.max(time[nxt], time[cur]+co[nxt]);

                if(in[nxt]==0){
                    Q.offer(nxt);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if(best<time[i])
                best=time[i];
        }
        System.out.println(best);

    }
}