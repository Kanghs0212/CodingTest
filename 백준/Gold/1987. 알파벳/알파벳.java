import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int x,y,cost;

        public Node(int x,int y, int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    static int N,M;
    static Queue<Node> Q = new LinkedList<>();
    static boolean[][] check;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    static int best=0;
    static int[] alpha = new int[26];

    public static void dfs(int x ,int y,int count){
        if(best<count)
            best=count;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=M)
                continue;
            if(!check[nx][ny] && alpha[map[nx][ny]-65]==0){
                check[nx][ny]=true;
                alpha[map[nx][ny]-65]=1;
                dfs(nx,ny, count+1);
                alpha[map[nx][ny]-65]=0;
                check[nx][ny]=false;
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
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]=tmp.charAt(j);
            }
        }

        check[0][0]=true;
        alpha[map[0][0]-65]=1;
        dfs(0,0,1);

        System.out.println(best);
    }
}