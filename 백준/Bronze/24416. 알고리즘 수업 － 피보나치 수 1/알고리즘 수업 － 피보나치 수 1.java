import java.util.*;
import java.io.*;

public class Main {

    static int recur_cnt=0;
    static int dp_cnt=0;
    static int[] dp = new int[41];
    public static int fibo(int n){
        if(n==1 || n==2){
            recur_cnt++;
            return 1;
        }

        else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static int fibonacci(int n){
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            dp_cnt++;
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        fibo(N);
        fibonacci(N);
        System.out.print(recur_cnt + " " + dp_cnt);
    }
}