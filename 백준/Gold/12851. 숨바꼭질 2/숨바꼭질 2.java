import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int idx, cnt;

        public Pair(int idx, int cnt){
            this.idx=idx;
            this.cnt=cnt;
        }
    }
    static int N,M;
    static int ans=Integer.MAX_VALUE;
    static int ways=1;
    static int[] way = new int[100001];
    static boolean[] check = new boolean[100001];
    static Queue<Pair> Q = new LinkedList<>();

    public static void bfs(int idx){
        Q.offer(new Pair(idx, 0));
        check[idx]=true;

        while (!Q.isEmpty()){
            Pair cur = Q.poll();

            if(cur.idx==M){
                if(cur.cnt<ans){
                    ans=cur.cnt;
                    ways=0;
                }
                if(cur.cnt==ans)
                    ways++;
                continue;
            }

            check[cur.idx]=true;
            if(cur.cnt+1<=ans){
                if(cur.idx-1>=0 && !check[cur.idx-1])
                    Q.offer(new Pair(cur.idx-1, cur.cnt+1));
                if(cur.idx+1<100001 && !check[cur.idx+1])
                    Q.offer(new Pair(cur.idx+1, cur.cnt+1));

                if(cur.idx*2<100001 && !check[cur.idx*2])
                    Q.offer(new Pair(cur.idx*2, cur.cnt+1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if(N>=M){
            System.out.println(N-M);
            System.out.println(1);
            return;
        }
        bfs(N);

        System.out.println(ans);
        System.out.println(ways);
    }
}