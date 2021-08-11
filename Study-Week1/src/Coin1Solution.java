import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin1Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);
        int[] coins = new int[N];
        for(int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(br.readLine());

        int[] caseCnt = new int[K + 1];
        caseCnt[0] = 1;
        for(int i = 0; i < N; i++) {
            int coin = coins[i];
            for (int value = 1; value <= K; value++) {
                // 그 전 코인들로 현재값을 만들 수 있는 경우의 수 + 그 코인들로 (현재값-이번코인값)을 만들 수 있는 경우의 수
                // ex) 1, 2로 10을 만들 수 있는 경우의 수 + 1,2로 5를 만들 수 있는 경우의 수
                if(value >= coin)
                    caseCnt[value] = caseCnt[value] + caseCnt[value - coin];
                else
                    continue;
            }
        }
        System.out.println(caseCnt[K]);
    }
}