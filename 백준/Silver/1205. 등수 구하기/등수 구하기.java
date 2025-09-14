import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        ArrayList<Integer> rank = new ArrayList<>();

        if(N>0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                rank.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(rank, Collections.reverseOrder());
        }

        for (int i = N; i < P; i++) {
            rank.add(0);
        }

        int newRank = 1;

        for (int i = 0; i <= N; i++) {
            if(i+1>P){
                newRank=-1;
                break;
            }
            int curRankScore = rank.get(i);
            
            if(curRankScore<newScore){
                break;
            }else if(curRankScore==newScore){
                continue;
            }
            newRank++;
        }
        System.out.println(newRank);
    }
}
