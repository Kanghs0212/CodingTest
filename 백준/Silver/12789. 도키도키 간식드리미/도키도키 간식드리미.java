import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        st=new StringTokenizer(br.readLine());

        int front= 1;

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        while (true) {
            if(list.isEmpty()){
                break;
            }
            int tmp = list.get(0);
            if(!stack.isEmpty() && stack.peek()==front){
                stack.pop();
                front++;
            }
            else if(tmp==front){
                front++;
                list.remove(0);
            }
            else if(tmp>front){
                stack.push(tmp);
                list.remove(0);
            }
        }

        while (!stack.isEmpty()){
            int tmp = stack.pop();
            if(tmp>front){
                System.out.println("Sad");
                return;
            }
            else
                front++;
        }
        System.out.println("Nice");
        
    }
}