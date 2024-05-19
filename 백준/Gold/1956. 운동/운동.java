import java.util.*;
import java.io.*;


public class Main {
    static int[][] graph;
    static int V,E;
    static final int INF = 987654321;
    static int ans = INF;
    static boolean flag=false;

    public static void floyd(){
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 1; k <=V ; k++) {
                    if(i==j)
                        continue;

                    graph[j][k]= Math.min(graph[j][k], graph[j][i]+graph[i][k]);
                }
            }
        }
        for(int i=1; i<V+1; i++)
        {
            for(int j=1; j<V+1; j++)
            {
                if(i==j)
                    continue;

                if(graph[i][j]!=INF && graph[j][i]!=INF)
                {
                    ans = Math.min(ans, graph[i][j]+graph[j][i]);
                    flag=true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V=Integer.parseInt(st.nextToken());
        E= Integer.parseInt(st.nextToken());

        graph = new int[V+1][V+1];
        for (int i = 1; i < V+1; i++) {
            for (int j = 1; j < V+1; j++) {
                if(i==j) continue;
                graph[i][j]=INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[first][second]= cost;
        }

        floyd();
        if(!flag){
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }
}