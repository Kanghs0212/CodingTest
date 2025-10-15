import java.io.*;
import java.util.*;


class Point{
    int x;
    int y;
    int cnt;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
        this.cnt=0;
    }
    public Point(int x,int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }

    boolean isEqual(Point ob){
        if((ob.x == this.x) && (ob.y == this.y))
            return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        // 도착지 파악
        Point dest;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='D')
                    dest = new Point(i,j);
            }
        }

        boolean flag  = false;
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='S')
                    q.add(new Point(i,j));
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='*')
                    q.add(new Point(i,j));
            }
        }

        while (!q.isEmpty()){
            Point cur = q.poll();
            char type = map[cur.x][cur.y];

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if((nx<R) && (nx>=0) && (ny<C) && (ny>=0) && (map[nx][ny]!='X')){
                    if(type=='S'){
                        if(map[nx][ny]=='.'){
                            map[nx][ny]='S';
                            q.add(new Point(nx,ny, cur.cnt+1));
                        }else if(map[nx][ny]=='D'){
                            System.out.println(cur.cnt+1);
                            System.exit(0);
                        }
                    }else if(type=='*'){
                        if(map[nx][ny]=='S' || map[nx][ny]=='.'){
                            map[nx][ny]='*';
                            q.add(new Point(nx, ny));
                        }
                    }
                }

            }
        }

        System.out.println("KAKTUS");

    }
}
