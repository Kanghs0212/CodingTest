import java.util.*;
import java.io.*;


public class Main {

    static Queue<Integer> Q = new LinkedList<>();
    static int N,M;
    static int[][] map;
    static int best=0;
    static boolean[][] check;
    static int[][] d1 = {{-1,0,1,0},{0,1,0,-1}};
    static int[][] d2 = {{0,1,0,-1},{1,0,-1,0}};
    public static void find(int index,int sum){
        if(index==N*M){
            best = Math.max(best,sum);
            return;
        }

        int x = index/M;
        int y = index%M;

        for (int i = 0; i < 4; i++) {

            int x1 = x + d1[0][i];
            int y1 = y + d1[1][i];
            int x2 = x + d2[0][i];
            int y2 = y + d2[1][i];
            if(x1<0 || x2<0 || y1<0 || y2<0|| x1>=N || x2>=N || y1>=M || y2>=M
               || check[x1][y1] || check[x2][y2] || check[x][y]){
                continue;
            }

            check[x][y]=true;
            check[x1][y1]=true;
            check[x2][y2]=true;

            find(index+1,sum + map[x][y]*2 + map[x1][y1] + map[x2][y2]);

            check[x][y]=false;
            check[x1][y1]=false;
            check[x2][y2]=false;
        }

        find(index+1,sum);


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        find(0,0);
        System.out.println(best);

    }
}