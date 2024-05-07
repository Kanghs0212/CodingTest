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
    static char[][] map;
    static int N;
    static ArrayList<Pair> teacher=new ArrayList<>();

    static boolean flag=false;
    public static boolean check(){
        for(Pair cur : teacher){
            int nx = cur.x;
            int ny = cur.y;
            while (nx<N-1){
                nx++;
                if(map[nx][ny]=='S')
                    return false;
                else if(map[nx][ny]=='O')
                    break;
            }
            nx = cur.x;
            while (ny<N-1){
                ny++;
                if(map[nx][ny]=='S')
                    return false;
                else if(map[nx][ny]=='O')
                    break;
            }
            ny = cur.y;
            while (nx>0){
                nx--;
                if(map[nx][ny]=='S')
                    return false;
                else if(map[nx][ny]=='O')
                    break;
            }
            nx = cur.x;
            while (ny>0){
                ny--;
                if(map[nx][ny]=='S')
                    return false;
                else if(map[nx][ny]=='O')
                    break;
            }

        }
        return true;
    }

    public static void find(int depth, int x,int y){
        if(depth==3){
            if(check()) {
                flag = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]=='S' || map[i][j]=='T' || map[i][j]=='O')
                    continue;
                if(i<x || (i==x && j<y))
                    continue;

                map[i][j]='O';
                find(depth+1, i,j);
                map[i][j]='X';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            int index=0;
            for (int j = 0; j < N+(N-1); j+=2) {
                map[i][index]=tmp[j];
                if(tmp[j]=='T')
                    teacher.add(new Pair(i,index));
                index++;
            }
        }

        find(0, 0,0);
        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}