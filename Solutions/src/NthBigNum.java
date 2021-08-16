import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class NthBigNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] temp;

        PriorityQueue<Integer> table = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                table.offer(Integer.parseInt(temp[j]));
                if(table.size() > N)
                    table.poll();
            }
        }
        System.out.println(table.poll());
    }
}
