import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int count=0;
        map.put("ChongChong", 1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String fir = st.nextToken();
            String sec = st.nextToken();

            if(map.getOrDefault(fir,0)>0 || map.getOrDefault(sec, 0)>0){
                map.put(fir,1);
                map.put(sec, 1);
            }
        }

        for (String key : map.keySet()){
            if(map.getOrDefault(key, 0)>0)
                count++;
        }

        System.out.println(count);
    }
}