import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x,y;
        int cost;

        public Node(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }

    static int N,M;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] check;
    static Queue<Node> Q = new LinkedList<>();

    public static void bfs(int x,int y){
        Q.offer(new Node(x,y,0));
        check[x][y]=true;

        while (!Q.isEmpty()){
            Node cur = Q.poll();
            map[cur.x][cur.y]=cur.cost;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx<0 || ny<0 || nx>=N ||ny>=M)
                    continue;
                if(!check[nx][ny]){
                    check[nx][ny]=true;
                    if (map[nx][ny]!=0)
                        Q.offer(new Node(nx,ny,cur.cost+1));
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==2 && !check[i][j]){
                    bfs(i,j);
                    break;
                }
            }
        }

        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!check[i][j] && map[i][j]!=0)
                    SB.append(-1).append(" ");
                else
                    SB.append(map[i][j]).append(" ");
            }
            SB.append("\n");
        }

        bw.write(SB.toString());
        bw.close();
    }
}