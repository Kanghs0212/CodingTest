import java.util.*;
import java.io.*;

public class Main {

    static Integer[] dp = new Integer[1000001];
    public static int find(int X){
        dp[1]=0;
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
        int index=1;
        for (int i = 3; i < 1000000; i*=3) {
            dp[i]=index;
            index++;
        }
        index=1;
        for (int i = 2; i < 1000000; i*=2) {
            dp[i]=index;
            index++;
        }
        System.out.println(find(N));

    }
}