import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] graph;
    public static int start;
    public static int end;

    public static void dfs(int cur, int count){
        if(visited[cur]) return;
        visited[cur]=true;
        if(cur == end){
            System.out.println(count);
            System.exit(0);
        }

        for(int key: graph[cur]){
            dfs(key, count+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int E = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            graph[p1].add(p2);
            graph[p2].add(p1);
        }

        dfs(start, 0);

        System.out.println(-1);
    }
}
