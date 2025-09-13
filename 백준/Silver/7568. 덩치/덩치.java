import java.io.*;
import java.util.*;

class Person{
    int weight;
    int height;

    public Person(int weight, int height){
        this.weight=weight;
        this.height=height;
    }
}

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people.add(new Person(weight, height));
        }

        for (int i = 0; i < N; i++) {
            int rank = N;
            Person person = people.get(i);
            for (int j = 0; j < N; j++) {
                if(j==i)
                    continue;
                Person other = people.get(j);

                if(!((person.weight<other.weight) && (person.height<other.height)))
                    rank--;

            }
            sb.append(rank + " ");
        }
        System.out.println(sb);
    }
}