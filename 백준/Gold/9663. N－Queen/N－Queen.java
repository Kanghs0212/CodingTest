import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] map;
    static int ans=0;
    static boolean[][] check;

    public static void dfs(int cnt){
        if(cnt==N){
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!check[cnt][i]){
               if(!checkin(cnt,i)){
                   map[cnt][i]=1;
                   dfs(cnt+1);
                   map[cnt][i]=0;
               }
            }
        }

    }
    public static boolean checkin(int x, int y){
        int tx=x;
        int ty=y;
        while (tx>=0){
            if(map[tx][ty]==1)
                return true;
            tx--;
        }
        tx=x;
        while (tx<N){
            if(map[tx][ty]==1)
                return true;
            tx++;
        }
        tx=x;
        while (tx>=0 && ty>=0){
            if(map[tx][ty]==1)
                return true;
            tx--;
            ty--;
        }
        tx=x;
        ty=y;
        while (tx>=0 && ty<N){
            if(map[tx][ty]==1)
                return true;
            tx--;
            ty++;
        }
        tx=x;
        ty=y;
        while (tx<N && ty<N){
            if(map[tx][ty]==1)
                return true;
            tx++;
            ty++;
        }
        tx=x;
        ty=y;
        while (tx<N && ty>=0){
            if(map[tx][ty]==1)
                return true;
            tx++;
            ty--;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N=Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            check = new boolean[N][N];
            map = new int[N][N];
            checkin(0,i);
            map[0][i]=1;
            dfs(1);
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }
}