import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ClassroomAssign {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] temp;
        PriorityQueue<Lecture> lectures = new PriorityQueue<>();   // 시작시간 , 종료시간 순 소팅
        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            lectures.offer(new Lecture(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        /** main algorithm **/
        PriorityQueue<Lecture> tempQue = new PriorityQueue<>(); // 다른 큐2 하나 만들기
        int room = 0;
        while(!(lectures.isEmpty() && tempQue.isEmpty())) {
            // 하나 폴해서 시작시간 종료시간 세팅. room = 1
            Lecture now = lectures.poll();
            int start = now.start; int end = now.end;
            room++;
            // 큐1이 비지 않는 동안
            while (!lectures.isEmpty()) {
                now = lectures.poll(); // 큐1에서 폴하면서
                // 시작시간이 현재 종료시간보다 같거나 크면 종료시간 다시 세팅
                if (now.start >= end) end = now.end;
                else tempQue.offer(now); // 아니면 큐2에 넣기
            }
            // 큐1과 큐2 스왑! -> 큐2가 큐1이 되고 큐1이 큐2가 되게함. 둘다 비면 종료.
            PriorityQueue<Lecture> tmp = lectures;
            lectures = tempQue;
            tempQue = tmp;
        }

        System.out.println(room);
    }

    public static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {  // 다중 정렬 (start -> end)
            if(this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }
}