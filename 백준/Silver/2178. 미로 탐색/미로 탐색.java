import java.io.*;
import java.util.*;


public class Main {

    static char[][] map;
    static boolean[][] visit;
    static int N,M;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int best=-1;

    static class Node{
        int x,y;
        int cost;

        public Node(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }

    public static void bfs(int x,int y){
        Node tmp = new Node(x,y,1);
        visit[x][y]= true;
        Queue<Node> Q = new LinkedList<>();
        Q.offer(tmp);

        while (!Q.isEmpty()){
            Node cur = Q.poll();
            if(cur.x == N-1 && cur.y == M-1){
                best = cur.cost;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx>=N || nx<0 || ny>=M || ny<0)
                    continue;

                if( !visit[nx][ny] && map[nx][ny]!='0') {
                    visit[nx][ny] = true;
                    Q.offer(new Node(nx, ny, cur.cost + 1));
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        bfs(0,0);
        System.out.println(best);
    }
}
