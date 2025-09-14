import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lights = new int[N];

        for (int i = 0; i < N; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int loc = num - 1;

            if (sex == 1) {
                for (int j = loc; j < N; j += num) {
                    lights[j] = (lights[j] + 1) % 2;

                }
            } else {
                boolean flag = true;
                int dist = 1;
                while (flag && loc - dist >= 0 && loc + dist < N) {
                    if (lights[loc - dist] == lights[loc + dist])
                        dist++;
                    else {
                        flag = false;
                    }
                }
                dist--;
                for (int j = loc - dist; j <= loc + dist; j++) {
                    lights[j] = (lights[j] + 1) % 2;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if(i%20==0 && i!=0){
                System.out.println();
            }
            System.out.print(lights[i] + " ");
        }
    }
}
