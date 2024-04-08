import java.util.*;
import java.io.*;

public class Main {

    static int[] dp = new int[1000001];

    public static int tile(int n){
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        for (int i = 3; i <= n; i++) {
            dp[i]=(dp[i-2]+dp[i-1])%15746;
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        System.out.println(tile(N));
    }
}