class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        String[] time = pos.split(":");
        int min = Integer.parseInt(time[0]);
        int sec = Integer.parseInt(time[1]);

        time = op_start.split(":");
        int start_min = Integer.parseInt(time[0]);
        int start_sec = Integer.parseInt(time[1]);

        time = op_end.split(":");
        int end_min = Integer.parseInt(time[0]);
        int end_sec = Integer.parseInt(time[1]);

        time = video_len.split(":");
        int video_min = Integer.parseInt(time[0]);
        int video_sec = Integer.parseInt(time[1]);
        
    

        for(int i = 0 ; i<commands.length; i++){
            String command = commands[i];
            time = pos.split(":");
            min = Integer.parseInt(time[0]);
            sec = Integer.parseInt(time[1]);
            
    
            boolean isOp = check(min,sec,start_min,start_sec,end_min,end_sec);
            
            if(isOp){
                min = end_min;
                sec = end_sec;
            }
            
            if(command.equals("prev")){
            
                sec-=10;
                if(sec<0){
                    min-=1;
                    sec=60+sec;
                }    
                if(min<0){
                    min=0;
                    sec=0;
                }
             
                    
                
            }else if(command.equals("next")){
                sec+=10;
                if(sec>59){
                    min+=1;
                    sec=sec-60;
                }   
                
                if((min>video_min) || (min==video_min && sec>=video_sec)){
                    min=video_min;
                    sec=video_sec;
                }
            }
            
            pos = toString(min,sec);
        
        }
        
        boolean isOp = check(min,sec,start_min,start_sec,end_min,end_sec);
            
        if(isOp){
            min = end_min;
            sec = end_sec;
        }
        pos = toString(min,sec);
    
        String answer = pos;
        return answer;
    }
    
    boolean check(int min, int sec, int start_min, int start_sec, int end_min, int end_sec){
        if((start_min<min && min<end_min)){
            return true;
        }else if((start_min==min && min<end_min)){
            if(start_sec<=sec)
                return true;
        }else if(start_min<min && min==end_min){
            if(end_sec>=sec){
                return true;
            }
        }else if(start_min==min && end_min==start_min){
            if(start_sec<= sec && sec<=end_sec)
                return true;
        }
        
        return false;
    }
    
    String toString(int min, int sec){
        String tmpMin;
        String tmpSec;
        
        if(min<10)
            tmpMin = 0 +"" +min;
        else
            tmpMin = min + "";
        
        if(sec < 10)
            tmpSec = 0 + "" + sec;
        else
            tmpSec = sec + "";
        
        return tmpMin + ":" + tmpSec;
        
    }
}