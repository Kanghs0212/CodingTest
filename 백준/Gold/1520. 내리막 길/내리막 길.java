import java.io.*;
import java.util.*;

public class Main {

    static int M;
    static int N;

    static int[][] map;
    static long[][] dp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result = 0;

    public static long dfs(int x,int y){
        if((x==M-1) && (y==N-1)){return 1;}
        if(dp[x][y]!=-1) return dp[x][y];

        long cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=M || ny>=N )
                continue;

            if(map[nx][ny]<map[x][y])
                cnt += dfs(nx,ny);
        }

        dp[x][y]=cnt;
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new long[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }
}