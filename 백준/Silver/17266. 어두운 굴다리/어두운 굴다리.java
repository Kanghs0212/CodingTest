import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int loc = 0;
        int maximumGap = 0;
        int first=0;
        int last=0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int curLoc = Integer.parseInt(st.nextToken());
            if(i==0)
                first = curLoc;
            else if(i==M-1)
                last = curLoc;

            int gap = ((curLoc - loc)/2)+((curLoc - loc)%2);
            maximumGap = Math.max(gap, maximumGap);

            loc = curLoc;
        }

        maximumGap = Math.max(Math.max(first, N-last), maximumGap);
        System.out.println(maximumGap);

    }
}