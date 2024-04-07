import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] num;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    
    public static void back(int index, int cnt, String ans){
        if(cnt==M){
            sb.append(ans).append("\n");
            return;
        }

        for (int i = index; i <N ; i++) {
            if(check[i])
                continue;
            check[i]=true;
            back(i+1, cnt+1, ans+num[i]+" ");
            check[i]=false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        num = new int[N];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            num[i]=i+1;
        }
        back(0,0,"");

        System.out.println(sb);
    }
}