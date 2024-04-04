import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    static int blue=0;
    static int white=0;

    public static void cut(int x1, int x2,int y1,int y2){
        int color=map[x1][y1];
        boolean flag=false;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if(map[i][j]!=color){
                    flag=true;
                    break;
                }
            }
        }
        if(flag){
            int gap= (x2-x1)/2;
            cut(x1, x1+gap, y1, y1+gap);
            cut(x1+gap, x2, y1, y1+gap);
            cut(x1, gap+x1, gap+y1, y2);
            cut(x1+gap, x2, y1+gap, y2);
        }
        else{
            if(color==1)
                blue++;
            else
                white++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        cut(0,N,0,N);

        System.out.println(white);
        System.out.println(blue);
    }
}