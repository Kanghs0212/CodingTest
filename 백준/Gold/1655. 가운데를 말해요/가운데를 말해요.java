import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxq = new PriorityQueue<>();
        int median = Integer.parseInt(br.readLine());
        sb.append(median).append("\n");

        int maxq_size=0;
        int minq_size=0;
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(median<=num && (maxq_size-minq_size)==0){
                maxq.offer(num);
                maxq_size++;
            }
            else if(median>num && (maxq_size-minq_size)==0){
                minq.offer(num);
                num=minq.poll();

                maxq.offer(median);
                median = num;
                maxq_size++;
            }
            else if(median<=num && (maxq_size-minq_size)>0){
                minq.offer(median);

                maxq.offer(num);
                num=maxq.poll();

                median = num;
                minq_size++;
            }
            else if(median>num && (maxq_size-minq_size)>0){
                minq.offer(num);
                minq_size++;
            }
            sb.append(median).append("\n");
        }

        bw.write(sb.toString());
        bw.close();

    }
}