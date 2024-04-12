import java.util.*;
import java.io.*;

public class Main {

    static int[] in;
    static ArrayList<Integer>[] graph;
    static int V,E;
    static Queue<Integer> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V+1];
        in = new int[V+1];
        Arrays.fill(in, 0);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < V+1; i++) {
            graph[i]=new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
            in[second]++;
        }

        for (int i = 1; i < V+1; i++) {
            if(in[i]==0)
                Q.offer(i);
        }

        while (!Q.isEmpty()){
            int cur = Q.poll();
            sb.append(cur).append(" ");

            for (int i = 0; i < graph[cur].size(); i++) {
                int nxt = graph[cur].get(i);
                in[nxt]--;
                if(in[nxt]==0)
                    Q.offer(nxt);
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}