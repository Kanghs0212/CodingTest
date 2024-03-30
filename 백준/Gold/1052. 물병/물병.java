import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ones = Integer.bitCount(N);
        if(K>=ones){
            System.out.println(0);
            return;
        }
        int cnt=0;
        while(ones>K){
            cnt++;
            N++;
            ones = Integer.bitCount(N);
        }
        System.out.println(cnt);
    }
}