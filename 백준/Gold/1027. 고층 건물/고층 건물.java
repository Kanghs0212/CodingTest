import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] map;
    public static double incline(int i, int idx){
        return (double)(map[idx]-map[i]) / Math.abs(i-idx);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i]= Integer.parseInt(st.nextToken());
        }
        
        int best=0;
        for (int i = 0; i < N; i++) {
            double left_min=-Integer.MAX_VALUE;
            double right_min=-Integer.MAX_VALUE;
            int count=0;

            for (int j = i-1; j >= 0; j--) {
                double tmp = incline(i, j);
                if(left_min<tmp){
                    count++;
                    left_min=tmp;
                }
            }
            for (int j = i+1; j < N; j++) {
                double tmp = incline(i, j);
                if(right_min<tmp){
                    count++;
                    right_min=tmp;
                }
            }
            best=Math.max(best,count);
        }
        System.out.println(best);
    }
}