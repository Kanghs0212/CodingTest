import java.util.*;
import java.io.*;


public class Main {

    static class Pair{
        int x,y;
        int cnt;
        public Pair(int x,int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static char[][] map;
    static int N,M;
    static Queue<Pair> JQ = new LinkedList<>();
    static Queue<Pair> FQ = new LinkedList<>();
    static Queue<Pair> tmp = new LinkedList<>();
    static boolean[][] check;
    static int cntJ= 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='J'){
                    JQ.offer(new Pair(i,j, 1));
                    cntJ++;
                }

                if(map[i][j]=='F'){
                    FQ.offer(new Pair(i,j, 1));
                    check[i][j]=true;
                }
            }
        }


        while (cntJ !=0 && !JQ.isEmpty()){

            while (!JQ.isEmpty()){
                Pair cur = JQ.poll();
                if(map[cur.x][cur.y]=='F')
                    continue;

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx<0 || nx>=N || ny<0 || ny>=M){

                        System.out.println(cur.cnt);
                        return;
                    }

                    if(map[nx][ny]=='.'){
                        map[nx][ny]='J';
                        cntJ++;
                        tmp.offer(new Pair(nx,ny,cur.cnt+1));
                    }
                }
            }
            while (!tmp.isEmpty()){
                JQ.offer(tmp.poll());
            }

            while (!FQ.isEmpty()){
                Pair cur = FQ.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx<0 || nx>=N || ny<0 || ny>=M || check[nx][ny])
                        continue;

                    if(map[nx][ny]!='#'){
                        check[nx][ny]=true;
                        if(map[nx][ny]=='J')
                            cntJ--;
                        map[nx][ny]='F';

                        tmp.offer(new Pair(nx,ny, cur.cnt+1));
                    }
                }
            }
            while (!tmp.isEmpty()){
                FQ.offer(tmp.poll());
            }

        }

        System.out.println("IMPOSSIBLE");
    }
}