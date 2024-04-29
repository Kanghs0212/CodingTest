import java.util.*;
import java.io.*;

public class Main {

    static Integer[][] dp;
    public static int find(int i, int n){

        if(dp[n][i]==null){
            if(i==0){
                dp[n][i]=find(i+1,n-1)%1000000000;
            }
            else if(i==9){
                dp[n][i]=find(i-1,n-1)%1000000000;
            }
            else{
                dp[n][i]=(find(i-1,n-1)+find(i+1,n-1))%1000000000;
            }
        }
        return dp[n][i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        dp = new Integer[N+1][10];
        dp[1][0]=0;
        for (int i = 1; i <10 ; i++) {
            dp[1][i]=1;
        }
        long sum = 0;

        for (int i = 0; i < 10; i++) {
            sum+=find(i,N);
            sum%=1000000000;
        }

        System.out.println(sum%1000000000);
    }
}