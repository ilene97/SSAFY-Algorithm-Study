import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
                if(value >= coin)
                    caseCnt[value] = caseCnt[value] + caseCnt[value - coin];
                else
                    continue;
            }
            // System.out.println(Arrays.toString(caseCnt));
        }
        System.out.println(caseCnt[K]);

    }
}
