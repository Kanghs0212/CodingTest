import java.util.*;
import java.io.*;

public class Main {
    static int N,M,B;
    static int[][] map;
    static int max,min;
    static int time=Integer.MAX_VALUE;
    static int fin=0;
    public static void push(int diff){
        for (int i = 0; i <= diff; i++) {
            int height=min+i;
            int block=B;
            int new_time=0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int gap = height-map[j][k];
                    if(gap<0){
                        new_time+=(-gap)*2;
                        block+=(-gap);
                    }
                    else if(gap>0){
                        new_time+=gap;
                        block-=gap;
                    }
                }
            }
            if(block<0)
                break;
            if(time>=new_time){
                time=new_time;
                fin=height;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        max = -1;
        min = 257;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                } else if (map[i][j] < min) {
                    min = map[i][j];
                }
            }
        }
        int diff=max-min;
        push(diff);
        System.out.print(time+ " ");
        System.out.println(fin);
    }
}