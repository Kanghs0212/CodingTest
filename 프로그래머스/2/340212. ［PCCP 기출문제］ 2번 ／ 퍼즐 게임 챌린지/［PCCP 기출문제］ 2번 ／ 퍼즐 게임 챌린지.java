class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 1;
        int plus=1;
        boolean flag = false;
        
        while(!flag){
            long time = 0;
            
            for(int i = 0; i<diffs.length; i++){
                int gap = diffs[i] - answer;
                if(gap<=0){
                    time+=times[i];
                }else if(gap>0 && i>0){
                    time+= (times[i-1] + times[i]) * gap + times[i];
                }else{
                    time+= (times[i]) * gap + times[i];
                }
            }
            
            if(time>limit){
                answer+=plus;
                plus++;
            }
            else
                flag=true;
        }
        
        if(plus>1){
            flag = false;
            answer-=plus;
            while(!flag){
            
                long time = 0;

                for(int i = 0; i<diffs.length; i++){
                    int gap = diffs[i] - answer;
                    if(gap<=0){
                        time+=times[i];
                    }else if(gap>0 && i>0){
                        time+= (times[i-1] + times[i]) * gap + times[i];
                    }else{
                        time+= (times[i]) * gap + times[i];
                    }
                }

                if(time>limit){
                    answer++;
                }
                else
                    flag=true;
            }
        }
        return answer;
    }
}