package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Resignation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        String[] temp;
        for (int i = 1; i <= N; i++) {
            temp = br.readLine().split(" ");
            T[i] = Integer.parseInt(temp[0]);
            P[i] = Integer.parseInt(temp[1]);
            dp[i] = P[i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i - j >= T[j])  // j날 상담기간이 지나고 i날 상담을 할 수 있으면
                    dp[i] = Math.max(P[i] + dp[j], dp[i]);
            }
        }

        // int max = IntStream.of(dp).max().getAsInt();
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (i + T[i] <= N + 1 && max < dp[i])
                    max = dp[i];
        }
        System.out.println(max);
    }
}
