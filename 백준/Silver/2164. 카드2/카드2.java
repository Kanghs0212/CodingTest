import java.util.*;
import java.io.*;


public class Main {

    static Queue<Integer> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            Q.offer(i);
        }


        while (Q.size() > 1) {
            Q.poll();

            if (Q.size() == 1) {
                break;
            }

            Q.offer(Q.poll());
        }

        sb.append(Q.poll());
        bw.write(sb.toString());
        bw.close();
    }
}