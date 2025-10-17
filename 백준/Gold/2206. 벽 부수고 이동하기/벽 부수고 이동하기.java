import java.io.*;
import java.util.*;

class Point{
    int x;
    int y;
    int broken;
    int cnt;
    public Point(int x,int y, int broken){
        this.x=x;
        this.y=y;
        this.broken=broken;
        this.cnt = 1;
    }

    public Point(int x,int y, int broken, int cnt){
        this.x=x;
        this.y=y;
        this.broken=broken;
        this.cnt = cnt;
    }
}

public class Main {

    static int N;
    static int M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][][] visited;
    static Queue<Point> q = new LinkedList<>();


    public static int bfs(){
        q.add(new Point(0,0,0));
        visited[0][0][0]=true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == N-1 && cur.y == M-1) {
                return cur.cnt;
            }

            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + cur.x;
                int ny = dy[k] + cur.y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M )
                    continue;

                if(map[nx][ny]=='0' && !visited[nx][ny][cur.broken]){
                    visited[nx][ny][cur.broken]=true;
                    q.add(new Point(nx,ny,cur.broken,cur.cnt+1));
                }else if(map[nx][ny]=='1'&& cur.broken==0 && !visited[nx][ny][1]){
                    visited[nx][ny][1]=true;
                    q.add(new Point(nx,ny,1, cur.cnt+1));
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        // 벽을 지우지 않았을 때

        System.out.println(bfs());
    }
}
