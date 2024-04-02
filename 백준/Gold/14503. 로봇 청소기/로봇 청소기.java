import java.util.*;
import java.io.*;

public class Main {
    static int N, M, x,y;
    static int head;
    static int cnt=0;
    static int[] bx={1,0,-1,0};
    static int[] by={0,-1,0,1};
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int[][] map;

    public static boolean check(int x,int y){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(map[nx][ny]==0)
                return true;
        }
        return false;
    }

    public static boolean bmove(int head){
        int nx = x + bx[head];
        int ny = y+ by[head];
        if(map[nx][ny]==1){
            return false;
        }
        else{
            x = nx;
            y = ny;
            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        x= Integer.parseInt(st.nextToken());
        y= Integer.parseInt(st.nextToken());
        head=Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        boolean flag=true;

        while(flag){
            if(map[x][y]==0){
                cnt++;
                map[x][y]=2;
            }
            if(check(x,y)){
                head=(head+3)%4;
                int nx = x + dx[head];
                int ny = y + dy[head];
                if(map[nx][ny]==0){
                    x=nx;
                    y=ny;
                }
            }
            else{
                flag=bmove(head);
            }
        }
        System.out.println(cnt);
    }
}