import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());


        int N;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            long gain = 0;
            int cur;
            int nxt;
            int highest = 0;
            Stack<Integer> stack = new Stack<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stack.push(Integer.parseInt(st.nextToken()));
            }


            while (!stack.isEmpty()){
                cur = stack.pop();
                if(cur>highest)
                    highest=cur;

                if (stack.isEmpty())
                    break;
                nxt = stack.peek();

                if(highest>nxt){
                    gain += highest-nxt;
                }

            }

            sb.append(gain + "\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}