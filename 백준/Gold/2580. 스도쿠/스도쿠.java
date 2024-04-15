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

    static int[][] map = new int[9][9];
    static boolean[] check = new boolean[10];
    static int stop = 0;
    static ArrayList<Pair> blink = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void sudoku(int count){
        if(count==blink.size()){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            stop = 1;
            return;
        }
        if(stop==1)
            return;
        Pair cur = blink.get(count);
        for (int i = 1; i < 10; i++) {
            if(checkin(cur.x, cur.y, i)){
                 map[cur.x][cur.y]=i;
                 sudoku(count+1);
                 map[cur.x][cur.y]=0;
            }
        }
    }

    public static boolean checkin(int x,int y, int N){
        for (int i =(x/3)*3; i<(x/3)*3+3;i++){
            for (int j = (y/3)*3; j<(y/3)*3+3;j++){
                if(map[i][j]==N){
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if(map[x][i]==N)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if(map[i][y]==N)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    blink.add(new Pair(i,j));
                }
            }
        }
        sudoku(0);

        bw.write(sb.toString());
        bw.close();

    }
}