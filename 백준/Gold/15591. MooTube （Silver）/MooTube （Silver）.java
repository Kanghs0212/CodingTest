import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<Integer>[] graph;
    static int[][] map;
    static boolean[] check;
    static int N,Q;
    static Queue<Integer> Queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i]=new ArrayList<>();
        }
        map = new int[N+1][N+1];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

            graph[first].add(second);
            graph[second].add(first);
            map[first][second]=usado;
            map[second][first]=usado;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int count = 0;

            check = new boolean[N+1];
            Queue.offer(v);
            check[v]=true;

            while (!Queue.isEmpty()){
                int vortex = Queue.poll();

                for (int key: graph[vortex]){
                    if(check[key] || map[vortex][key]<k)
                        continue;

                    check[key]=true;
                    count++;
                    Queue.offer(key);
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}