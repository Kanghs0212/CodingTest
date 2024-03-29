import java.io.*;
import java.util.*;


public class Main {

    public static double calc(double credit, String grade){
        if(grade.equals("A+"))
            return credit * 4.5;
        else if(grade.equals("A0"))
            return credit * 4.0;
        else if(grade.equals("B+"))
            return credit * 3.5;
        else if(grade.equals("B0"))
            return credit * 3.0;
        else if(grade.equals("C+"))
            return credit * 2.5;
        else if(grade.equals("C0"))
            return credit* 2.0;
        else if(grade.equals("D+"))
            return credit * 1.5;
        else if(grade.equals("D0"))
            return credit * 1.0;
        else
            return 0;

    }
    static double all_credit=0;
    static double all=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 20 ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(grade.equals("P"))
                continue;

            all_credit +=credit;
            all+=calc(credit, grade);
        }
        System.out.println(all/all_credit);

    }
}
