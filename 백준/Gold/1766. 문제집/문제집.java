import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] problem;
    static PriorityQueue<Integer> Q = new PriorityQueue<>();
    static int N,M;
    static int[] edge_in;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        problem = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            problem[i] = new ArrayList<>();
        }
        edge_in = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            problem[from].add(to);
            edge_in[to]++;
        }
        for (int i = 0; i < N; i++) {
            if(edge_in[i]==0){
                Q.offer(i);
            }
        }
        StringBuilder SB= new StringBuilder();

        while (!Q.isEmpty()){
            int point = Q.poll();
            SB.append((point+1) +" ");

            for (int i = 0; i < problem[point].size(); i++) {
                edge_in[problem[point].get(i)]--;
                if(edge_in[problem[point].get(i)]==0){
                    Q.offer(problem[point].get(i));
                }
            }
        }
        System.out.println(SB);
    }
}