import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;

    static class Pair{
        int weight, cost;

        public Pair(int we,int co){
            this.weight=we;
            this.cost=co;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] co = new int[N+1];
        int[] we = new int[N+1];
        dp = new int[N+1][K+1];
        ArrayList<Pair> tmp = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tmp.add(new Pair(weight,cost));
        }
        Collections.sort(tmp, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.weight-o2.weight;
            }
        });

        for (int i = 1; i <= N ; i++) {
            Pair cur = tmp.get(i-1);
            int weight=cur.weight;
            int cost = cur.cost;
            for (int j = 1; j <= K; j++) {
                if(j-weight>=0){
                    dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weight]+cost);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}