package Week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiceBuild {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> opposite = new HashMap<>();
        opposite.put(0, 5); opposite.put(5, 0);
        opposite.put(1, 3); opposite.put(3, 1);
        opposite.put(2, 4); opposite.put(4, 2);
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> dices = new ArrayList<>();
        String[] temp;
        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            int[] numbers = new int[6];
            for(int j = 0; j < 6; j++)
                numbers[j] = Integer.parseInt(temp[j]);
            dices.add(numbers);
        }
        br.close();

        int answer = 0;
        int[] firstDice = dices.get(0);
        for(int i = 0; i < 6; i++){     // 첫번째 주사위의 i번째가 위로 오게!
            int sum = 0;
            int preTopNum = firstDice[i];

            int max = 0;
            for(int k = 0; k < 6; k++){ // i번째 면과 그 반대 면을 제외한 숫자들 중 최대값 찾기
                if(k == i || k == opposite.get(i))  continue;
                max = Math.max(max, firstDice[k]);
            }
            sum += max;

            for(int d = 1; d < N; d++){ // 두번째 ~ N 번째 주사위 까지
                int[] dice = dices.get(d);
                int curBottomIdx = -1;
                for(int k = 0; k < 6; k++){ // 이전 주사위의 윗면과 같은 숫자인 인덱스 찾기
                    if(preTopNum == dice[k]) curBottomIdx = k;
                }

                max = 0;
                for(int k = 0; k < 6; k++){ // 현재 바닥면과 그 반대 면을 제외한 숫자들 중 최대값
                    if(k == curBottomIdx || k == opposite.get(curBottomIdx))  continue;
                    max = Math.max(max, dice[k]);
                }
                sum += max;

                preTopNum = dice[opposite.get(curBottomIdx)];   // 윗면 변경
            }

            answer = Math.max(answer, sum); // 더 큰 값으로 정답 변경
        }
        System.out.println(answer);


    }
}
