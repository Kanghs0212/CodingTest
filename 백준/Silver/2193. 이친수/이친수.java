import java.util.*;
import java.io.*;

public class Main {

    static long[] dp = new long[91];
    public static long find(int n){

        if(dp[n]==0){
            dp[n]=find(n-2)+find(n-1);
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        dp[0]=0;
        dp[1]=1;
        dp[2]=1;

        long ans = find(N);
        System.out.println(ans);
    }
}