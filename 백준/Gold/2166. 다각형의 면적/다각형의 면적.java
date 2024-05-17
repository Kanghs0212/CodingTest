import java.util.*;
import java.io.*;


public class Main {
    public static double area(double x1,double y1, double x2,double y2, double x3, double y3){
        return (x1*y2 + x2*y3 + x3*y1) - (x1*y3 + x3*y2 + x2*y1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        double ans = 0;

        st = new StringTokenizer(br.readLine());
        double px = Double.parseDouble(st.nextToken());
        double py = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double before_x = Double.parseDouble(st.nextToken());
        double before_y = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double cur_x = Double.parseDouble(st.nextToken());
        double cur_y = Double.parseDouble(st.nextToken());

        ans+=area(px,py,before_x,before_y,cur_x,cur_y);

        for (int i = 3; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            before_x=cur_x;
            before_y=cur_y;
            cur_x = Double.parseDouble(st.nextToken());
            cur_y = Double.parseDouble(st.nextToken());
            ans+=area(px,py,before_x,before_y,cur_x,cur_y);
        }

        System.out.printf("%.1f", Math.abs(ans)/2);
    }
}