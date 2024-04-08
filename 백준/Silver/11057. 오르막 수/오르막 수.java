import java.util.*;
import java.io.*;

public class Main {

    static Integer[][] dp;
    public static int find(int N, int index){

        if(dp[N][index]==null){
            dp[N][index]=(find(N-1,index) + find(N,index+1))%10007;
        }
        return dp[N][index];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        dp = new Integer[N+2][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i]=1;
        }
        for (int i = 2; i <= N+1; i++) {
            dp[i][9]=1;
        }
        long sum=find(N+1,0);
        System.out.println(sum%10007);
    }
}