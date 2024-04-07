import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] person = new int[N];
        for (int i = 0; i < N; i++) {
            person[i]=0;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cnt=Integer.parseInt(st.nextToken());
            int index=0;
            while (cnt>0){
                while (person[index]!=0){
                    index++;
                }
                cnt--;
                index++;
            }
            while (person[index]!=0){
                index++;
            }

            person[index]=i;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(person[i] + " ");
        }
    }
}