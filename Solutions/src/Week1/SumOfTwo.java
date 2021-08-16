package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfTwo {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(temp[i]);
        int x = Integer.parseInt(br.readLine());
        br.close();

        /** main algorithm - using two pointers**/
        int pairs = 0;
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++)
                if(numbers[i] + numbers[j] == x) {
                    pairs++;
                    break;  // 브레이크 안넣어주면 시간 초과
                }
        }
        System.out.println(pairs);  // output
    }
}