import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();

        int req=0;
        if(gameType.equals("Y"))
            req=1;
        else if (gameType.equals("F"))
            req=2;
        else
            req=3;

        HashSet<String> users = new HashSet<>();

        for (int i = 0; i < N; i++)
            users.add(br.readLine());
        int userCnt = users.size();

        System.out.println(userCnt/req);

    }
}