import java.util.*;
import java.io.*;


public class Main {

    static int[] dice = new int[7];
    static int[][] map;
    static int N,M;
    static int x,y;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};

    public static void move(int d){
        int nx = x + dx[d-1];
        int ny = y + dy[d-1];
        if(nx>=N || nx<0 || ny>=M || ny<0)
            return;
        roll(nx,ny, d);
        x=nx;
        y=ny;
    }

    public static void roll(int x, int y, int d){
        int tmp = dice[3];
        if(d==1){
            dice[3]=dice[2];
            dice[2]=dice[6];
            dice[6]=dice[4];
            dice[4]=tmp;
        }
        else if(d==2){
            dice[3]=dice[4];
            dice[4]=dice[6];
            dice[6]=dice[2];
            dice[2]=tmp;
        }
        else if(d==3){
            dice[3]=dice[5];
            dice[5]=dice[6];
            dice[6]=dice[1];
            dice[1]=tmp;
        }
        else{
            dice[3]=dice[1];
            dice[1]=dice[6];
            dice[6]=dice[5];
            dice[5]=tmp;
        }
        if(map[x][y]==0)
            map[x][y]=dice[6];
        else{
            dice[6]=map[x][y];
            map[x][y]=0;
        }
        System.out.println(dice[3]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int d = Integer.parseInt(st.nextToken());
            move(d);
        }
    }

}