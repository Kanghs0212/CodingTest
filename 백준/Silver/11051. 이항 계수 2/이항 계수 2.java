import java.util.*;
import java.io.*;


public class Main {
    static int N,K;
    static Integer[][] dp = new Integer[1001][1001];
    static int[] coin;

    public static int find(int n, int k){
        if(n<0 || k<0)
            return 0;
        if(dp[n][k]==null){

            dp[n][k]=(find(n-1,k)%10007)+(find(n-1,k-1)%10007);

        }
        return dp[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp[1][0]=1;
        dp[1][1]=1;
        dp[2][0]=1;
        dp[2][1]=2;
        dp[2][2]=1;

        long ans = find(N,K);

        System.out.println(ans%10007);

    }
}