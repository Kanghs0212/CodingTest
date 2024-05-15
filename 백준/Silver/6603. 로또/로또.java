import java.util.*;
import java.io.*;


public class Main {

    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int K;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void back(int depth, int index){
        if(depth==6){
            for (int i = 0; i < 6; i++) {
                System.out.print(ans.get(i));
                System.out.print(" ");
            }
            System.out.println();
            return;
        }
        if(index>=K)
            return;

        ans.add(list.get(index));
        back(depth+1, index+1);
        ans.remove(ans.size()-1);
        back(depth, index+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K==0)
                break;
            list.clear();

            for (int i = 0; i < K; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            back(0,0);
            System.out.println();
        }

        bw.write(sb.toString());
        bw.close();

    }
}