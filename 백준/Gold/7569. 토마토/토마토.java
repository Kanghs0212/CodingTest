import java.io.*;
import java.util.*;


public class Main {
    static int N,M,H;
    static int[][][] map;
    static boolean[][][] check;

    static int[] dx = new int[] {1,0,-1,0,0,0};
    static int[] dy = new int[] {0,1,0,-1,0,0};
    static int[] dz = new int[] {0,0,0,0,1,-1};
    static Queue<Pair> Q = new LinkedList<>();
    static int normal=0;
    static int day=-1;
    static class Pair{
        int x,y,z;
        int cnt;

        public Pair(int z,int x,int y, int cnt){
            this.x=x;
            this.y=y;
            this.z=z;
            this.cnt=cnt;
        }
    }

    public static void bfs(){
        while(!Q.isEmpty()){
            Pair cur = Q.poll();
            for (int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nz>=H || nz<0 || nx>= N || nx<0 || ny>=M || ny<0)
                    continue;
                if(check[nz][nx][ny] || map[nz][nx][ny]==-1 || map[nz][nx][ny]==1)
                    continue;
                check[nz][nx][ny]=true;
                Q.offer(new Pair(nz,nx,ny, cur.cnt+1));
                map[nz][nx][ny]=1;
                normal--;

            }
            if(day<cur.cnt)
                day=cur.cnt;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        check = new boolean[H][N][M];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[k][i][j]=Integer.parseInt(st.nextToken());
                    if(map[k][i][j]==1){
                        Q.offer(new Pair(k,i,j, 0));
                        check[k][i][j]=true;
                    }
                    if(map[k][i][j]==0)
                        normal++;

                }
            }
        }
        bfs();
        if(normal>0){
            System.out.println(-1);
            return;
        }
        System.out.println(day);
    }
}