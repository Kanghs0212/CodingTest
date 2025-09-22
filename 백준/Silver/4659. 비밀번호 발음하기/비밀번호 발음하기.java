import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String pw;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        while (!(pw = br.readLine()).equals("end")){
            boolean flag1=false;
            boolean flag2=true;
            boolean flag3=true;

            for (char key : vowels){
                if(pw.contains(Character.toString(key))){
                    flag1=true;
                    break;
                }
            }

            if(flag1){
                char[] pwList = pw.toCharArray();
                char before = 0;
                boolean isVowelBef = false;
                boolean isFirst=true;
                int streak=1;

                for (char cur : pwList){
                    boolean isVowelCur = false;
                    if(isFirst){
                        before=cur;
                        for(char vowel : vowels) {
                            if (vowel == before){
                                isVowelBef = true;
                                break;
                            }
                        }
                        isFirst=false;
                        continue;
                    }

                    for(char vowel : vowels){
                        if(vowel == cur){
                            isVowelCur=true;
                            break;
                        }
                    }

                    if(isVowelCur && isVowelBef){
                        streak++;
                    }else if(!isVowelBef && !isVowelCur)
                        streak++;
                    else
                        streak=1;

                    if(streak>=3)
                        flag2=false;

                    
                    if(cur==before){
                        if(cur!='e' && cur!='o'){
                            flag3=false;
                            break;
                        }
                    }
                    before=cur;
                    isVowelBef=isVowelCur;
                }

            }

            if(flag1 && flag2 && flag3)
                sb.append("<" + pw + "> is acceptable.\n");
            else
                sb.append("<" + pw + "> is not acceptable.\n");
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '\n') {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }
}
