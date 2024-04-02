import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = new int[] {0,1,0,-1};
    static int[] dy = new int[] {-1,0,1,0};
    static int out_sand = 0;
    static int[][] sx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] sy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] ratio = new int[] {1,1,2,7,7,2,10,10,5};
    static int[] move = new int[] {1,1,2,2};
    public static void simulation(int x,int y){
        int cur_x=x;
        int cur_y=y;

        while (true){
            for (int i = 0; i < 4; i++) {
                for (int c = 0; c < move[i]; c++) {
                    int nxt_x = cur_x + dx[i];
                    int nxt_y = cur_y + dy[i];
                    if (nxt_x < 0 || nxt_y < 0 || nxt_x >= N || nxt_y >= N)
                        return;
                    int sand = map[nxt_x][nxt_y];
                    map[nxt_x][nxt_y] = 0;
                    int sum = 0;

                    for (int j = 0; j < 9; j++) {
                        int nnxt_x = nxt_x + sx[i][j];
                        int nnxt_y = nxt_y + sy[i][j];
                        int get_sand = (sand * ratio[j]) / 100;
                        if (nnxt_x < 0 || nnxt_y < 0 || nnxt_x >= N || nnxt_y >= N) {
                            out_sand += get_sand;
                        } else {
                            map[nnxt_x][nnxt_y] += get_sand;
                        }
                        sum += get_sand;
                    }

                    int ax = nxt_x + dx[i];
                    int ay = nxt_y + dy[i];
                    if (ax < 0 || ax >= N || ay < 0 || ay >= N) {
                        out_sand += sand - sum;
                    } else
                        map[ax][ay] += sand - sum;

                    cur_x = nxt_x;
                    cur_y = nxt_y;
                }
            }
            for (int i = 0; i < 4; i++) {
                move[i]+=2;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        simulation(N/2,N/2);
        System.out.println(out_sand);
    }
}