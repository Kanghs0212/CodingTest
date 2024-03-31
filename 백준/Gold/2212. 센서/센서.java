import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] gap = new int[N-1];
        int[] tmp = new int[N];

        for (int i = 0; i < N; i++) {
            tmp[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tmp);

        for (int i = 0; i < N-1; i++) {
            gap[i]=tmp[i+1]-tmp[i];
        } // tmp배열을 정렬 시키고 옆의 요소와의 차를 구함

        Arrays.sort(gap);

        int index = N-2;
        for (int i = 0; i < K-1; i++) {
            index--;
        } // gap 배열을 정렬시키고 gap값이 큰 요소는 삭제

        int sum=0;
        for (int i = 0; i <= index; i++) {
            sum+=gap[i];
        }

        System.out.println(sum);
    }
}