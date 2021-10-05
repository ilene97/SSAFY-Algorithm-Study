package Week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 신입사원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Person> people = new ArrayList<>();
            String[] temp;
            for(int i = 0; i < N; i++) {
                temp = br.readLine().split(" ");
                people.add(new Person(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
            }

            Collections.sort(people); // 서류 1등부터 N등까지 sort
            int answer = 1; // 일단 서류 1등 채용
            int interviewStandard = people.get(0).interview; // 인터뷰 통과 등수 기준을 서류 1등 기준으로
            for(int i = 1; i < N; i++){
                // 현재 인터뷰 기준보다 등수 높으면 채용
                if(people.get(i).interview < interviewStandard){
                    answer++;
                    // 인터뷰 기준 바꾸기 (뒤에 있는 애들은 i보다 서류 등수 낮으므로 인터뷰 등수가 i보다 높아야함)
                    interviewStandard = people.get(i).interview;
                }
            }
            System.out.println(answer);
        }
    }

    public static class Person implements Comparable<Person>{
        int paper;
        int interview;

        Person(int paper, int interview){
            this.paper = paper;
            this.interview = interview;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "paper=" + paper +
                    ", interview=" + interview +
                    '}';
        }

        @Override
        public int compareTo(Person o) {
            return this.paper - o.paper;
        }
    }
}
