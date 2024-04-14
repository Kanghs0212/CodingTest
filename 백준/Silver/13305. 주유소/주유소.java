import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long ans = 0;
        int N = Integer.parseInt(st.nextToken());
        long[] len = new long[N];
        long[] cost = new long[N];

        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            long tmp =Integer.parseInt(st.nextToken());
            len[i]=tmp;
        }

        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i]=Integer.parseInt(st.nextToken());
        }

        int index=0;
        while (true){
            if(index+1>=N){

                break;
            }
            if(cost[index]>cost[index+1]){
                ans+=len[index]*cost[index];
                index++;
            }
            else{
                long tmp=len[index];
                int now = index;
                while (index+2<N &&cost[now]<=cost[index+1]){
                    index++;
                    tmp+=len[index];
                }
                ans+=tmp*cost[now];
                index++;
            }
        }
        System.out.println(ans);
    }
}