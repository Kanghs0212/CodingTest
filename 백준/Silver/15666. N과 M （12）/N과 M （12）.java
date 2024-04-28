import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] nums;
    static HashMap<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int num, int cnt, String str){
        if(cnt==M){
            if(map.getOrDefault(str, 0)==0) {
                map.put(str, map.getOrDefault(str, 0)+1);
                sb.append(str + "\n");
                return;
            }
            else{
                return;
            }
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