import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int best = 0;
        int cnt = 0;
        int[] num = new int[X];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < X; i++) {
            num[i]= Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            best += num[i];
        }
        int sum = best;
        cnt++;

        for (int i = 1; i <= X-N; i++) {
            sum-=num[i-1];
            sum+=num[i+N-1];
            if(sum>best){
                best=sum;
                cnt=1;
            }
            else if(sum==best)
                cnt++;
        }
        if(best==0)
            System.out.println("SAD");
        else{
            System.out.println(best);
            System.out.println(cnt);
        }
    }
}