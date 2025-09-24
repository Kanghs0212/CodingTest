import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder dfsSB = new StringBuilder();
        StringBuilder bfsSB = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        boolean[] dfsVisited = new boolean[N+1];
        boolean[] bfsVisited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            graph[p1].add(p2);
            graph[p2].add(p1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        //1. DFS
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        while (!stack.isEmpty()){
            int cur = stack.pop();
            if (dfsVisited[cur]) continue;
            dfsVisited[cur] = true;
            dfsSB.append(cur + " ");

            for (int i = graph[cur].size() - 1; i >= 0; i--) {
                int nxt = graph[cur].get(i);
                if (!dfsVisited[nxt]) {
                    stack.push(nxt);
                }
            }
        }

        //2. BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        bfsVisited[start]=true;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            bfsSB.append(cur + " ");

            for(int key : graph[cur]){
                if(!bfsVisited[key]){
                    bfsVisited[key]=true;
                    queue.add(key);
                }
            }
        }
        System.out.println(dfsSB);
        System.out.println(bfsSB);
    }
}
