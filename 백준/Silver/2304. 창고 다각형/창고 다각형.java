import java.util.*;
import java.io.*;

public class Main {
    static int[] height;
    static int N = 0;
    static int highest=0;
    static int left=Integer.MAX_VALUE;
    static int right=-Integer.MAX_VALUE;
    static int INDEX=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        height = new int[1001];

        int ans=0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            height[index]=len;
            if(index>right)
                right=index;
            if(index<left)
                left=index;
            if(len>highest){
                highest=len;
                INDEX=index;
            }
        }

        ans+=highest;
        double before=height[left];

        for (int i = left; i <INDEX ; i++) {
            int cur=height[i];
            if(height[i]>0){
                if(cur>=before){
                    ans+=cur;
                    before=cur;
                }
                else{
                    ans+=before;
                }
            }
            else if(height[i]==0){
                ans+=before;
            }
        }
        before=height[right];

        for (int i = right; i > INDEX ; i--) {
            if(height[i]>0){
                int cur = height[i];
                if(cur>before){
                    ans+=cur;
                    before=cur;
                }
                else{
                    ans+=before;
                }
            }
            else if(height[i]==0){
                ans+=before;
            }
        }
        System.out.println(ans);

    }
}