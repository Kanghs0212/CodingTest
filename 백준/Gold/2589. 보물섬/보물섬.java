import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x,y;
        int cnt;

        public Node(int x,int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }
    static int N,M;
    static int[] dx = new int[] {1,0,-1,0};
    static int[] dy = new int[] {0,1,0,-1};
    static char[][] map;
    static boolean[][] check;
    static int ans = 0;
    static Queue<Node> Q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='L'){
                    Q.offer(new Node(i,j,0));
                    check = new boolean[N][M];
                    check[i][j]=true;

                    while (!Q.isEmpty()){
                        Node cur = Q.poll();
                        if(cur.cnt>ans)
                            ans=cur.cnt;

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if(nx>=0 && nx<N && ny>=0 && ny<M && !check[nx][ny]
                                    && map[nx][ny]=='L'){
                                Q.offer(new Node(nx,ny,cur.cnt+1));
                                check[nx][ny]=true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}