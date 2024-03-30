import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] people;
    static int N;
    static boolean[] check;
    static int score=1;
    static class Pair{
        int index,point;

        public Pair(int i, int p){
            this.index=i;
            this.point=p;
        }
    }
    static Queue<Pair> Q = new LinkedList<>();

    public static void bfs(int index){
        Q.offer(new Pair(index, 0));
        check[index]=true;

        while (!Q.isEmpty()){
            Pair now = Q.poll();
            for (int i = 0; i < people[now.index].size(); i++) {
                int next=people[now.index].get(i);
                if(!check[next]){
                    Q.offer(new Pair(next, now.point+1));
                    check[next]=true;
                }
            }
            if(now.point>score)
                score=now.point;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        people = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            people[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int fir, sec;
        while((fir=Integer.parseInt(st.nextToken()))!=-1 &&
                (sec = Integer.parseInt(st.nextToken()))!=-1){
            people[fir-1].add(sec-1);
            people[sec-1].add(fir-1);
            st = new StringTokenizer(br.readLine());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int best=6;
        for (int i = 0; i < N; i++) {
            score=1;
            check = new boolean[N];
            bfs(i);
            if(score<best){
                ans.clear();
                ans.add(i);
                best=score;
            }
            else if(score==best){
                ans.add(i);
            }
        }
        Collections.sort(ans);
        System.out.println(best + " " + ans.size());
        for (int key : ans){
            System.out.print((key+1)+" ");
        }


    }
}