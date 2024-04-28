import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int num, int cnt, String str){
        if(cnt==M){
            sb.append(str + "\n");
            return;
        }
        if(num>N){
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(num<=i){
                dfs(i,cnt+1,str+i+" ");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(1,0,"");
        bw.write(sb.toString());
        bw.close();

    }
}