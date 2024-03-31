import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
    static int N;
    static class Pair{
        int day, score;
        public Pair(int day,int score){
            this.day=day;
            this.score=score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Pair[] list = new Pair[N];
        int max_day=0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new Pair(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            if(list[i].day>max_day)
                max_day=list[i].day;
        }

        Arrays.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.day - o2.day;
            }
        });
        int sum=0;
        while(max_day>0){
            for (int i = 0; i < N; i++) {
                if(list[i].day==max_day)
                    Q.offer(list[i].score);
            }
            max_day--;
            if(!Q.isEmpty()){
                sum+=Q.poll();
            }
        }
        System.out.println(sum);
    }
}
