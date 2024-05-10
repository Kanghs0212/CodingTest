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

    static Queue<Pair> Q = new LinkedList<>();
    static int N,M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] head = {0, 1, 2, 3};
    static boolean[][] check;
    static int[][] room_num;
    static int[][] map;
    static int[][] rooms;
    static int best=0;
    static int best_att=0;
    static int room_count=0;

    public static String bit(int x,int y){
        if(map[x][y]==0)
            return "0000";
        else if(map[x][y]==1)
            return "0001";
        else if(map[x][y]>1 && map[x][y]<=3){
            return "00" + Integer.toBinaryString(map[x][y]);
        }
        else if(map[x][y]>3 && map[x][y] <=7)
            return "0" + Integer.toBinaryString(map[x][y]);
        else
            return Integer.toBinaryString(map[x][y]);
    }

    public static void bfs(int x,int y){
        Q.offer(new Pair(x,y));
        check[x][y]=true;
        boolean[][] flag = new boolean[N][M];
        flag[x][y]=true;
        int count = 0;

        while (!Q.isEmpty()){
            Pair cur = Q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int header = head[i];
                String BIT = bit(cur.x,cur.y);

                if(nx<0||nx>=N || ny<0 || ny>=M || check[nx][ny])
                    continue;
                if(BIT.charAt(header)=='1')
                    continue;

                check[nx][ny]=true;
                flag[nx][ny]=true;
                Q.offer(new Pair(nx,ny));
            }
        }
        if(count>best)
            best=count;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(flag[i][j]){
                    rooms[i][j]=count;
                    room_num[i][j]=room_count;
                }
            }
        }
    }

    // 서쪽=1, 북쪽=2, 동쪽=4, 남쪽=8
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M= Integer.parseInt(st.nextToken());
        N= Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new boolean[N][M];
        rooms = new int[N][M]; // 맵에서 탐색한 방에, 해당 방은 칸이 몇개인지 표시하기위함
        room_num = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!check[i][j]){
                    room_count++;
                    bfs(i,j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx<0||nx>=N || ny<0 || ny>=M)
                        continue;
                    if(room_num[i][j]!=room_num[nx][ny]){
                        if(rooms[i][j]+rooms[nx][ny]>best_att)
                            best_att=rooms[i][j]+rooms[nx][ny];
                    }
                }
            }
        }

        System.out.println(room_count);
        System.out.println(best);
        System.out.println(best_att);

    }
}