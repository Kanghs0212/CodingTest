import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> hash = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            hash.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            String[] list = input.split(",");

            for(String key : list){
                hash.remove(key);
            }
            sb.append(hash.size() + "\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}