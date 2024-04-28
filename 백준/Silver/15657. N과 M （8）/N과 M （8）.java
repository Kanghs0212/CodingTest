import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int num, int cnt, String str){
        if(cnt==M){
            sb.append(str + "\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(num<=nums[i]){
                dfs(nums[i],cnt+1,str+nums[i]+" ");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(nums[1],0,"");
        bw.write(sb.toString());
        bw.close();

    }
}