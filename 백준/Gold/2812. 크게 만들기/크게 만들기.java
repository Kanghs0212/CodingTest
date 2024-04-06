import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int del = Integer.parseInt(st.nextToken());
        Stack<Integer> S = new Stack<>();
        StringBuilder SB = new StringBuilder();
        boolean flag=true;
        boolean first=true;
        int len = N-del;

        String[] tmp = br.readLine().split("");

        for (int i = 0; i < tmp.length; i++) {
            if(!S.isEmpty()){
                while (!S.isEmpty() && del >0 && Integer.parseInt(tmp[i])>S.peek()){
                    S.pop();
                    del--;
                }
            }
            S.push(Integer.parseInt(tmp[i]));
        }

        while (S.size() > len){
            S.pop();
        }

        while (!S.isEmpty()){
            SB.append(S.pop());
        }
        System.out.println(SB.reverse().toString());
    }
}