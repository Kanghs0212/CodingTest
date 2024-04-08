import java.util.*;
import java.io.*;

public class Main {

    static Integer[] dp = new Integer[1000001];
    public static int find(int X){
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;
        dp[4]=2;
        dp[5]=3;
        if(dp[X]==null){
            int first=find(X/3)+X%3+1;
            int second=find(X/2)+X%2+1;
            dp[X]= Math.min(first, second);
        }
        return dp[X];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        System.out.println(find(N));
    }
}