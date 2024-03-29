import java.util.*;
import java.io.*;


public class Main {

    static int N,L;
    static int[][] map;
    public static boolean row(int x, int y){
        int before = map[x][y];
        int con=1;
        while(true){
            y++;
            if(y>=N)
                break;
            int now=map[x][y];

            if(Math.abs(before-now)>=2)
                return false;

            if(before==now){
                con++;
                continue;
            }

            if(before-now==-1){
                if(con<L){
                    return false;
                }
                else
                    con=1;
            }

            else if(before-now==1){
                int need=1;
                while(true){
                    y++;
                    if(y>=N || map[x][y]!=now)
                        break;
                    need++;
                }
                if(need<L)
                    return false;
                y--;
                con=need-L;
            }

            before=now;
        }
        return true;
    }

    public static boolean col(int x, int y){
        int before = map[x][y];
        int con=1;
        while(true){
            x++;
            if(x>=N)
                break;
            int now=map[x][y];
            if(Math.abs(before-now)>=2)
                return false;

            if(before==now){
                con++;
                continue;
            }

            if(before-now==-1){
                if(con<L){
                    return false;
                }
                else
                    con=1;
            }

            else if(before-now==1){
                int need=1;
                while(true){
                    x++;
                    if(x>=N || map[x][y]!=now)
                        break;
                    need++;
                }
                if(need<L)
                    return false;
                x--;
                con=need-L;
            }
            before=now;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());

            }
        }
        int count=0;
        for (int i = 0; i < N; i++) {
            boolean flag = col(0,i);
            if(flag)
                count++;
        }

        for (int i = 0; i < N; i++) {
            boolean flag=row(i,0);
            if(flag)
                count++;
        }
        System.out.println(count);

    }

}