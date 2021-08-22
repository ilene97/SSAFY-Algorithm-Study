package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RollCake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        String[] temp;
        int expectedMax = 0, expectedPerson = 0;
        int p, k, len;
        int[] cake = new int[L+1];
        int[] piecePerPerson = new int[N+1];
        for(int i = 1; i <= N; i++){
            temp = br.readLine().split(" ");
            p = Integer.parseInt(temp[0]);
            k = Integer.parseInt(temp[1]);
            len = k - p + 1;

            // 가장 많은 조각을 받을 것으로 기대하는 방청객 번호
            if(expectedMax < len){
                expectedMax = len;
                expectedPerson = i;
            }

            int numOfMine = 0;
            for(int n = p; n <= k; n++)    // p부터 k까지 조각에 마킹
                if (cake[n] == 0) {
                    cake[n] = i;
                    numOfMine++;    // 내 케이크 개수 세기
                }
            piecePerPerson[i] = numOfMine;
        }

        int answer = 0, max = 0;
        for(int i = 1; i <= N; i++)
            if(max < piecePerPerson[i]){
                max = piecePerPerson[i];
                answer = i;
            }
        System.out.println(expectedPerson);
        System.out.println(answer);
    }
}
