import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] ans = new String[100];
        int index=0;

        while(n!=0){
            int flag=0;
            int[] road = new int[1422];
            int[] where = new int[n];
            int tmp;
            int best=0;
            Arrays.fill(where, 0);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                tmp = Integer.parseInt(st.nextToken());
                for (int j = tmp; j <tmp+200 ; j++) {
                    if(j==1422)
                        break;
                    road[j]=1;
                }
                if(best<tmp)
                    best=tmp;
            }
            if(1422-best>100){
                flag++;
            }

            for (int i = 0; i < 1422; i++) {
                if(road[i]==0){
                    flag++;
                }
            }
            if(flag==0){
                ans[index]="POSSIBLE";
            }
            else{
                ans[index]="IMPOSSIBLE";
            }
            index++;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < index; i++) {
            System.out.println(ans[i]);
        }
    }
}