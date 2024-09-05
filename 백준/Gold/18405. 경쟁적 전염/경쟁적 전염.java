import java.util.*;
import java.io.*;


public class Main {

    static class Node implements Comparable<Node>{
        int x,y;
        int cost;

        public Node(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);  // cost가 작을수록 우선
        }
    }

    static PriorityQueue<Node> q = new PriorityQueue<>();
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int K;

    static int time_limit=0;
    static int goal_x=0;
    static int goal_y=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        check = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        time_limit = Integer.parseInt(st.nextToken());
        goal_x = Integer.parseInt(st.nextToken())-1;
        goal_y = Integer.parseInt(st.nextToken())-1;


        for (int z = 0; z < time_limit; z++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]!=0 && !check[i][j]){
                        q.offer(new Node(i,j,map[i][j]));
                        check[i][j]=true;
                    }
                }
            }

            while (!q.isEmpty()) {
                Node cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx<0 || ny<0 || nx>=N || ny>=N || (map[nx][ny]<=cur.cost && map[nx][ny]!=0))
                        continue;
                    
                    if(!check[nx][ny]){
                        map[nx][ny]=cur.cost;
                    }
                }
            }

        }

        System.out.println(map[goal_x][goal_y]);
    }

}