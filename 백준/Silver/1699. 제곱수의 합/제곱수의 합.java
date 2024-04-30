import java.util.*;
import java.io.*;

public class Main {

    static Integer[] dp;

    public static void mem(int N){
        for (int i = 2; i*i <=N ; i++) {
            dp[i*i]=1;
        }
    }

    public static int find(int n){
        if(dp[n]==null){
            dp[n]=100001;
            for (int i = (int)Math.sqrt(n); i >=0 ; i--) {
                int tmp = (int)Math.pow(i,2);
                dp[n]= Math.min(find(n-tmp)+1, dp[n]);
            }

        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        dp= new Integer[100001];
        dp[1]=1;
        mem(N);
        int ans =find(N);
        System.out.println(ans);
    }
}