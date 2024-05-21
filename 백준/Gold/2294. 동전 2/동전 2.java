import java.util.*;
import java.io.*;


public class Main {
    static int N,K;
    static Integer[] dp = new Integer[100001];
    static int[] coin;

    public static int find(int n){
        if(dp[n]==null){
            int tmp = 100001;
            for (int i = 0; i < N; i++) {
                if(n-coin[i]<0)
                    continue;
                tmp = Math.min(tmp,find(n-coin[i]));
            }
            dp[n]=tmp+1;
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            coin[i]=tmp;
            dp[tmp]=1;
        }

        dp[0]=0;
        int ans = find(K);
        if(ans==100002)
            ans=-1;

        System.out.println(ans);

    }
}