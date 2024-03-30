import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int index, time;
    public Pair(int index, int time){
        this.index=index;
        this.time=time;
    }

    public int compareTo(Pair o){
        return this.time-o.time;
    }
}

public class Main {

    static ArrayList<Integer>[] Building;
    static PriorityQueue<Pair> Q = new PriorityQueue<>();
    static int N,M;
    static int[] edge_in;
    static int[] time;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Building = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            Building[i] = new ArrayList<>();
        }
        edge_in = new int[N];
        time = new int[N];
        ans = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp=Integer.parseInt(st.nextToken());
            time[i]=tmp;
            while((tmp=Integer.parseInt(st.nextToken())-1)!=-2){
                Building[tmp].add(i);
                edge_in[i]++;
            }
        }
        for (int i = 0; i < N; i++) {
            if(edge_in[i]==0){
                Q.offer(new Pair(i,time[i]));
            }
        }
        while (!Q.isEmpty()){
            Pair point = Q.poll();
            ans[point.index]=point.time;

            for (int i = 0; i < Building[point.index].size(); i++) {
                int next = Building[point.index].get(i);
                edge_in[next]--;
                if(edge_in[next]==0)
                    Q.offer(new Pair(next, point.time+time[next]));

            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(ans[i]);
        }
    }
}