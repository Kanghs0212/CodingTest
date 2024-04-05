import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sum=0;
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int tmp =Integer.parseInt(br.readLine());
            Q.offer(tmp);
        }
        if(N==1) {
            System.out.println(0);
            return;
        }

        while (Q.size()>1){
            int fir=Q.poll();
            int sec=Q.poll();
            int tmp = fir+sec;
            sum+=tmp;
            Q.offer(fir+sec);
        }
        System.out.println(sum);
    }
}