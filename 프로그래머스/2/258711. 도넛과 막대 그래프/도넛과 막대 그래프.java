import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    class Point{
        int p;
        int out,in;
        ArrayList<Integer> next = new ArrayList<>();

        public Point(int p, int out,int in){
            this.p=p;
            this.out=out;
            this.in=in;
        }

        public void insertList(int p){
            next.add(p);
        }

        public ArrayList<Integer> getList(){
            return next;
        }
    }

    HashMap<Integer,Point> map = new HashMap<>();
    public int[] solution(int[][] edges) {
        Point startPoint= checkMidPoint(edges);
        ArrayList<Integer> next = startPoint.getList();
        int[] answer = {startPoint.p,0,0,0};

        for (int i = 0; i < next.size(); i++) {
            int nextPointNumber = next.get(i);
            Point nextPoint = map.get(nextPointNumber);
            nextPoint.in--;

            if(nextPoint.getList().isEmpty())
                answer[2]++;
            else{
                boolean flag = false;
            
                while (!nextPoint.getList().isEmpty()){
                    ArrayList<Integer> list = nextPoint.getList();
                    if(list.size()>=2){
                        answer[3]++;
                        flag=true;
                        break;
                    }
                    else{
                        nextPoint = map.get(list.get(0));
                        if(nextPoint.p == nextPointNumber){
                            answer[1]++;
                            flag=true;
                            break;
                        }
                    }
                }
                if(!flag)
                    answer[2]++;
                
            }
        }


        return answer;
    }

    public void pointEdgeAdd(int p, int dest){
        if(map.containsKey(p)){
            Point point =map.get(p);
            point.out++;
            point.insertList(dest);
        }else{
            Point point = new Point(p,1,0);
            point.insertList(dest);
            map.put(p,point);
        }

        if(map.containsKey(dest)){
            Point point =map.get(dest);
            point.in++;
        }else{
            Point point = new Point(dest,0,1);
            map.put(dest,point);
        }
    }

    public Point checkMidPoint(int[][] edges){
        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int dest = edges[i][1];

            pointEdgeAdd(p,dest);
        }

        for (Integer key : map.keySet()) {
            Point point= map.get(key);
            if(point.out>=2 && point.in==0){
                return point;
            }
        }
        return new Point(-1,0,0);
    }
}