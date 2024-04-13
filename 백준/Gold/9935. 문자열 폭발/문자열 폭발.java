import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        char[] input = br.readLine().toCharArray();
        char[] exp = br.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);

            if(stack.size()>=exp.length){
                boolean flag=true;
                for (int j = 0; j < exp.length; j++) {
                    if(stack.get(stack.size()-exp.length+j)!=exp[j])
                        flag = false;
                }
                if(flag){
                    for (int j = 0; j < exp.length; j++) {
                        stack.pop();
                    }
                }

            }
        }
        if(stack.isEmpty()){
            System.out.println("FRULA");
            return;
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        bw.write(sb.toString());
        bw.close();
    }
}