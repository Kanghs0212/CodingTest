import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int absolute, x;
    public Pair(int abs,int x){
        this.absolute=abs;
        this.x=x;
    }
    public int compareTo(Pair target){
        if(this.absolute== target.absolute){
            return this.x - target.x;
        }
        return this.absolute-target.absolute;
    }
}

public class Main {

    static PriorityQueue<Pair> Q = new PriorityQueue<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder SB = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp==0){
                if(!Q.isEmpty()){
                    Pair cur = Q.poll();
                    SB.append(cur.x + "\n");
                }
                else
                    SB.append(0 + "\n");
            }
            else
                Q.offer(new Pair(Math.abs(tmp), tmp));
        }
        System.out.println(SB);
    }
}