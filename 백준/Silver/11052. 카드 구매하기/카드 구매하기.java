import java.util.*;
import java.io.*;

public class Main {

    static Integer[] dp = new Integer[1001];
    static int[] arr;
    public static int find(int n){

        if(dp[n]==null){
            dp[n]=arr[n];
            for (int i = 1; i <n ; i++) {
                dp[n]=Math.max(find(n-i)+arr[i],dp[n]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dp[1]=arr[1];

        int ans = find(N);
        System.out.println(ans);
    }
}