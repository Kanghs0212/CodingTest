import java.util.*;
import java.io.*;


public class Main {
    static class Node{
        int x,y,age;

        public Node(int x,int y,int age){
            this.x=x;
            this.y=y;
            this.age=age;
        }
    }
    static PriorityQueue<Node> Q = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
           return Integer.compare(o1.age, o2.age);
        }
    });

    static Queue<Node> Fe = new LinkedList<>();
    static Queue<Node> Seed = new LinkedList<>();
    static Queue<Node> tmp = new LinkedList<>();
    static int[][] A;
    static int[][] map;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,1,-1,0,1};
    static int N,M,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j]=5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());

            Q.offer(new Node(x,y,age));
        }

        while (K>0){
            K--;
            int tree_cnt=Q.size();
            if(tree_cnt==0){
                System.out.println(0);
                return;
            }

            // 봄
            for (int i = 0; i < tree_cnt; i++) {
                Node cur = Q.poll();
                if(map[cur.x][cur.y]<cur.age){
                    Fe.offer(new Node(cur.x, cur.y, cur.age/2));
                }
                else if(map[cur.x][cur.y]>=cur.age){
                    map[cur.x][cur.y]-=cur.age;
                    cur.age++;
                    if(cur.age%5==0)
                        Seed.offer(new Node(cur.x, cur.y, cur.age));
                    tmp.offer(new Node(cur.x, cur.y, cur.age));
                }
            }

            while (!tmp.isEmpty())
                Q.offer(tmp.poll());

            // 여름
            while (!Fe.isEmpty()){
                Node cur = Fe.poll();
                map[cur.x][cur.y]+=cur.age;
            }

            // 가을
            while (!Seed.isEmpty()){
                Node cur = Seed.poll();

                for (int i = 0; i < 8; i++) {
                    int nx = cur.x+dx[i];
                    int ny = cur.y+dy[i];

                    if(nx<0 || nx>=N || ny<0 || ny>=N)
                        continue;
                    Q.offer(new Node(nx,ny,1));
                }
            }

            // 겨울

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j]+=A[i][j];
                }
            }
        }

        int tree_cnt=Q.size();
        if(tree_cnt==0){
            System.out.println(0);
            return;
        }
        else
            System.out.println(tree_cnt);


    }
}