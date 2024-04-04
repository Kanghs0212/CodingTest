import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int x,y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int[][] map;
    static int N,M;
    static int safe=0;
    static int best=0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Pair> virus = new ArrayList<>();
    
    public static void dfs(int count){
        if(count==3){
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    map[i][j]=1;
                    dfs(count+1);
                    map[i][j]=0;
                }
            }
        }
    }

    public static void bfs(){
        Queue<Pair> Q = new LinkedList<>();
        int[][] map_tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            map_tmp[i] = map[i].clone();
        }
        int tmp_safe=safe;


        for (int i = 0; i < virus.size(); i++) {
            Pair cur = virus.get(i);
            Q.offer(new Pair(cur.x,cur.y));
        }
        while (!Q.isEmpty()){
            Pair cur = Q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M)
                    continue;
                if(map_tmp[nx][ny]==0){
                    map_tmp[nx][ny]=2;
                    tmp_safe--;
                    Q.add(new Pair(nx,ny));
                }

            }
        }
        if(best<tmp_safe)
            best=tmp_safe;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new Pair(i,j));
                }
                else if(map[i][j]==0)
                    safe++;
            }
        }
        safe-=3; // 벽을 3개는 무조건 세워야함.
        dfs(0);
        System.out.println(best);
    }
}