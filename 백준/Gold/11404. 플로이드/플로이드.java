import java.util.*;
import java.io.*;


public class Main {
    static final int INF = 987654321;
    static int[][] map;
    static int V,E;

    public static void floyd(){

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <=V ; i++) {
                for (int j = 1; j <=V ; j++) {
                    map[i][j]= Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(map[i][j] == INF) System.out.print(0+" ");
                else System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        V= Integer.parseInt(br.readLine());
        E= Integer.parseInt(br.readLine());

        map = new int[V+1][V+1];

        for (int i = 0; i < V+1; i++) {
            for (int j = 0; j < V+1; j++) {
                if(i==j)
                    continue;
                map[i][j]=INF;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[first][second]=Math.min(map[first][second], cost);
        }

        floyd();


    }
}