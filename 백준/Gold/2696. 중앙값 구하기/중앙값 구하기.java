import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(br.readLine());
            sb.append((size + 1) / 2).append('\n');
            int cnt = 0;
            StringTokenizer st = null;

            for (int j = 0; j < size; j++) {
                if(j%10==0)
                    st = new StringTokenizer(br.readLine());

                int cur = Integer.parseInt(st.nextToken());

                if(maxQ.isEmpty() || cur <= maxQ.peek()) maxQ.offer(cur);
                else minQ.offer(cur);

                if(maxQ.size() > minQ.size() + 1) minQ.offer(maxQ.poll());
                else if(minQ.size() > maxQ.size()) maxQ.offer(minQ.poll());


                if((j%2)==0){
                    sb.append(maxQ.peek()).append(" ");
                    cnt++;
                    if(cnt%10 == 0)
                        sb.append("\n");
                }
            }
            minQ.clear();
            maxQ.clear();
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
