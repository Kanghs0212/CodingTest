import java.util.*;
import java.io.*;


public class Main {

    static class Pair{
        int x,y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static char[][] map = new char[12][6];
    static boolean[][] check;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int total_delete=0;
    static Queue<Pair> Q = new LinkedList<>();

    public static int bfs(int x,int y){
        Q.offer(new Pair(x,y));
        check[x][y]=true;
        int count=1;
        char color=map[x][y];

        boolean[][] flag = new boolean[12][6]; // 이번 너비 탐색에서 들린곳들을 저장

        while (!Q.isEmpty()){
            Pair cur = Q.poll();
            flag[cur.x][cur.y]=true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx<0 || nx>=12 || ny<0 || ny>=6)
                    continue;
                if(check[nx][ny] || map[nx][ny]!=color)
                    continue;
                Q.offer(new Pair(nx,ny));
                check[nx][ny]=true;
                count++;
            }
        }

        if(count>=4){
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if(flag[i][j])
                        map[i][j]='.';
                }
            }
        }
        return count;
    }

    public static void gravity(){
        for (int i = 0; i < 6; i++){
            for (int j = 11; j >0; j--)  {
                int index=j;
                while (index>0 && map[index][i]=='.'){
                    index--;
                }
                char tmp = map[index][i];
                map[index][i]=map[j][i];
                map[j][i]=tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 12; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        while (true){
            boolean flag = false;
            int count;
            check = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    count = 0;
                    if(!check[i][j] && map[i][j]!='.'){
                        count = bfs(i,j);
                    }
                    if(count>=4)
                        flag=true;
                }
            }
            gravity();

            if(flag)
                total_delete++;

            if(!flag)
                break;

        }
        System.out.println(total_delete);
    }
}