import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Character>[] gear = new ArrayList[4];
    static Queue<Integer> in= new LinkedList<>();
    static Queue<Integer> tu=new LinkedList<>();

    public static void move(int index, int turn){
        if(turn==-1) {
            char tmp =gear[index].get(0);
            gear[index].remove(0);
            gear[index].add(tmp);
        }
        else{
            char tmp = gear[index].get(7);
            gear[index].remove(7);
            gear[index].add(0,tmp);
        }
    }
    public static void check(int index, int turn){
        int roll=turn;
        for (int i = index; i < 3; i++) {
            if(gear[i].get(2)!=gear[i+1].get(6)){
                roll=-roll;
                in.offer(i+1);
                tu.offer(roll);
            }
            else
                break;
        }
        roll=turn;
        for (int i = index; i > 0; i--) {
            if(gear[i].get(6)!=gear[i-1].get(2)){
                roll=-roll;
                in.offer(i-1);
                tu.offer(roll);
            }
            else
                break;
        }
        while (!in.isEmpty()){
            move(in.poll(), tu.poll());
        }
        move(index, turn);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            gear[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            char[] tmp = st.nextToken().toCharArray();
            for(char key : tmp)
                gear[i].add(key);
        }
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int turn = Integer.parseInt(st.nextToken());
            check(index-1, turn);

        }
        int sum = (Character.getNumericValue(gear[0].get(0)))
                + (Character.getNumericValue(gear[1].get(0))*2)
                + (Character.getNumericValue(gear[2].get(0))*4)
                + (Character.getNumericValue(gear[3].get(0))*8);
        System.out.println(sum);
    }
}