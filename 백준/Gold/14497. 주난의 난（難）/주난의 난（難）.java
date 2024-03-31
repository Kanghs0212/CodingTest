import java.util.*;
import java.io.*;


public class Main {
    static char[][] map;
    static int[] dx = new int[] {1,0,-1,0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static class Pair{
        int x, y, cnt;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static Queue<Pair> Q = new LinkedList<>();
    static int N,M;
    static boolean[][] check;

    public static void bfs(int x,int y){
        Q.offer(new Pair(x,y));
        check[x][y]=true;

        while (!Q.isEmpty()){
            Pair cur= Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx=cur.x + dx[i];
                int ny=cur.y + dy[i];
                if(nx>=N || nx<0 || ny>=M || ny<0)
                    continue;
                if(!check[nx][ny]) {
                    if (map[nx][ny] == '1' || map[nx][ny]=='#') {
                        map[nx][ny] = '0';
                        check[nx][ny] = true;
                    } else {
                        Q.offer(new Pair(nx, ny));
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Pair find = new Pair(0,0);
        Pair junan = new Pair(0,0);
        st = new StringTokenizer(br.readLine());
        junan.x=Integer.parseInt(st.nextToken())-1;
        junan.y=Integer.parseInt(st.nextToken())-1;
        find.x=Integer.parseInt(st.nextToken())-1;
        find.y=Integer.parseInt(st.nextToken())-1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i]=st.nextToken().toCharArray();
        }

        int count=0;
        while(map[find.x][find.y]=='#'){
            check = new boolean[N][M];
            bfs(junan.x, junan.y);
            count++;
        }
        System.out.println(count);
    }

}