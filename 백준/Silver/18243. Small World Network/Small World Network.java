import java.util.*;
import java.io.*;


public class Main {

    static int N,K;
    static int[][] map;
    static final int inf = 10000;

    public static void floyd(){
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <=N ; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j)
                    continue;
                map[i][j]=inf;
            }
        }


        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            map[first][second]=1;
            map[second][first]=1;
        }


        floyd();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(map[i][j]>6){
                    System.out.println("Big World!");
                    return;
                }
            }
        }

        System.out.println("Small World!");

    }

}