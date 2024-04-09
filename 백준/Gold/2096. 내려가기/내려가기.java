import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] map;
    static Integer[][] low;
    static Integer[][] high;

    public static int find_high(int N, int index){
        if(high[N][index]==null){
            if(index==1)
                high[N][index]=map[N][index]+Math.max(find_high(N-1,0),
                    Math.max(find_high(N-1,index),find_high(N-1,2)));
            else if(index==0)
                high[N][index]=map[N][index]+Math.max(find_high(N-1,index),find_high(N-1,index+1));

            else if(index==2) {
                high[N][index] = map[N][index] + Math.max(find_high(N - 1, index - 1), find_high(N - 1, index));

            }
        }
        return high[N][index];
    }

    public static int find_low(int N, int index){
        if(low[N][index]==null){
            if(index==1)
                low[N][index]=map[N][index]+Math.min(find_low(N-1,0),
                        Math.min(find_low(N-1,index),find_low(N-1,2)));
            else if(index==0)
                low[N][index]=map[N][index]+Math.min(find_low(N-1,index),find_low(N-1,index+1));

            else if(index==2) {
                low[N][index] = map[N][index] + Math.min(find_low(N - 1, index - 1), find_low(N - 1, index));

            }
        }
        return low[N][index];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N=Integer.parseInt(st.nextToken());
        map = new int[N+2][3];
        low = new Integer[N+2][3];
        high = new Integer[N+2][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 3; i++) {
            low[1][i]=map[1][i];
            high[1][i]=map[1][i];
            map[N+1][i]=0;
        }
        sb.append(find_high(N+1,1)).append(" ");
        sb.append(find_low(N+1,1));

        bw.write(sb.toString());
        bw.close();
    }
}