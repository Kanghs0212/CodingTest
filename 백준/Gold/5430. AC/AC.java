import java.util.*;
import java.io.*;


public class Main {
    static Deque<String> deq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());


        for (int i = 0; i < T; i++) {
            boolean flag=false;
            int header = 1;

            st = new StringTokenizer(br.readLine());
            String[] order = st.nextToken().split("");

            int cnt = Integer.parseInt(br.readLine());

            String input = br.readLine();
            input = input.replace("[","").replace("]","");
            String[] tmp = input.split(",");
            for (int j = 0; j < cnt; j++) {
                deq.addLast(tmp[j]);
            }

            for (int j = 0; j < order.length; j++) {
                if(order[j].equals("R")){
                    header*=-1;
                }
                else if(order[j].equals("D")){
                    if(deq.size()==0){
                        flag=true;
                        sb.append("error\n");
                        break;
                    }
                    if(header==1){
                        deq.removeFirst();
                    }
                    else if(header==-1){
                        deq.removeLast();
                    }
                }
            }

            if(flag)
                continue;

            sb.append("[");
            int deq_cnt = deq.size();
            for (int j = 0; j < deq_cnt; j++) {

                if(header==1)
                    sb.append(deq.removeFirst());
                else
                    sb.append(deq.removeLast());
                if(j!=deq_cnt-1){
                    sb.append(",");
                }
            }
            sb.append("]\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

}