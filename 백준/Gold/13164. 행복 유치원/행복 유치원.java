import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] gap = new int[N-1];
        int[] people = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            gap[i-1]=people[i]-people[i-1];
        }
        Arrays.sort(gap);
        int last=N-2;
        while(K>1){
            last--;
            K--;
        }
        int sum=0;
        for (int i = 0; i <= last; i++) {
            sum+=gap[i];
        }
        System.out.println(sum);
    }
}