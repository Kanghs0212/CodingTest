import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[][] map;
    static int best=0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] check;

    public static void dfs(int x,int y,int count, int sum){
        if(count==4){
            if(sum>best){
                best=sum;
            }
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M)
                continue;
            if(check[nx][ny])
                continue;

            if (count==2){
                check[nx][ny]=true;
                dfs(x,y, count+1, sum+map[nx][ny]);
                check[nx][ny]=false;
            }
            check[nx][ny]=true;
            dfs(nx,ny,count+1,sum+map[nx][ny]);
            check[nx][ny]=false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check[i][j]=true;
                dfs(i,j,1,map[i][j]);
                check[i][j]=false;
            }
        }
        System.out.println(best);
    }
}