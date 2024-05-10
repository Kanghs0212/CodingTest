import java.util.*;
import java.io.*;


public class Main {

    static char[][] map;
    static int[][] count;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,T;

    public static void discount(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (count[i][j] > 0) {
                    count[i][j]--;
                    if(count[i][j]==0)
                        boom(i,j);
                }
            }
        }

    }

    public static void boom(int x,int y){
        map[x][y]='.';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=M)
                continue;
            map[nx][ny]='.';
        }
    }

    public static void plant(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='.'){
                    map[i][j]='O';
                    count[i][j]=3;
                }
            }
        }
    }

    public static void showMap() throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        count = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i]= st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='O')
                    count[i][j]=3;
            }
        }

        if(T==1){
            showMap();
            return;
        }

        int timer=1;
        discount();

        while (timer!=T){
            timer++;
            discount();
            if(timer%2==0)
                plant();

        }

        showMap();

    }
}