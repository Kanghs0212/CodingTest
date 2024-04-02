import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int airc_upper;
    static int[][] map;
    static int[][] tmp;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int dust_sum=0;

    public static void spread(int x,int y){
        int dust_spread = map[x][y]/5;
        int cnt=0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny]==-1)
                continue;
            cnt++;
            tmp[nx][ny]+=dust_spread;
        }
        tmp[x][y]+=map[x][y] - dust_spread * cnt;
    }

    public static void air_up(){
        int nx = airc_upper;
        int ny = 0;

        while(nx>0){
            nx--;
            if(map[nx+1][ny]==-1) {
                dust_sum-=map[nx][ny];
                continue;
            }
            map[nx+1][ny]=map[nx][ny];
        }

        while (ny<M-1){
            ny++;
            map[nx][ny-1]=map[nx][ny];
        }

        while (nx< airc_upper){
            nx++;
            map[nx-1][ny]=map[nx][ny];
        }

        while (ny>1){
            ny--;
            map[nx][ny+1]=map[nx][ny];
        }
        map[nx][ny]=0;
    }

    public static void air_down(){
        int nx = airc_upper+1;
        int ny = 0;

        while(nx<N-1){
            nx++;
            if(map[nx-1][ny]==-1){
                dust_sum-=map[nx][ny];
                continue;
            }
            map[nx-1][ny]=map[nx][ny];
        }
        while (ny<M-1){
            ny++;
            map[nx][ny-1]=map[nx][ny];
        }

        while (nx> airc_upper+1){
            nx--;
            map[nx+1][ny]=map[nx][ny];
        }

        while (ny>1){
            ny--;
            map[nx][ny+1]=map[nx][ny];
        }
        map[nx][ny]=0;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        map = new int[N][M];
        boolean flag=false;
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j]==-1 && !flag){
                    airc_upper=i;
                    flag=true;
                }
                else dust_sum += map[i][j];
            }
        }
        dust_sum++; // 위에서 공기청정기 아래쪽의 -1도 더해진걸 복구해줌

        for (int i = 0; i < T; i++) {
            tmp = new int[N][M];
            tmp[airc_upper][0]=-1;
            tmp[airc_upper+1][0]=-1;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[j][k]>0){
                        spread(j,k);
                    }
                }
            }
            map=tmp.clone();
            air_up();
            air_down();
        }
        System.out.println(dust_sum);
    }
}