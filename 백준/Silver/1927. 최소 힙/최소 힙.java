import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input==0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll() + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }else{
                pq.add(input);
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
