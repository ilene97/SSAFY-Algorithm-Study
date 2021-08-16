package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeTo1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] memory = new int[N + 1];
        for(int i = 2; i <= N; i++) {
            // 세개의 방법으로 볼 수 있는 인덱스 저장
            int[] result = new int[3];
            if(i % 3 == 0) result[0] = i / 3;
            if(i % 2 == 0) result[1] = i / 2;
            result[2] = i - 1;

            // 위 방법으로 볼 수 있는 인덱스들 중에 가장 작은 값을 가진 아이 구하기
            int min = Integer.MAX_VALUE;
            for(int way = 0; way < 3; way++){
                if(result[way] != 0 && memory[result[way]] < min)
                    min = memory[result[way]];
            }
            memory[i] = min + 1;  // 최소 값에 나 자신 연산 1 더하기
        }
        System.out.println(memory[N]);
    }
}