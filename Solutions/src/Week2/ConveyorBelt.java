package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConveyorBelt {
    static int N, K;
    static int[] conveyor;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);
        conveyor = new int[2 * N];
        robot = new boolean[N];
        temp = br.readLine().split(" ");
        for(int i = 0; i < 2 * N; i++)
            conveyor[i] = Integer.parseInt(temp[i]);
        br.close();

        int k = 0, step = 0;
        while(true){
            step++;
            // 1. 회전
            int last = conveyor[2 * N - 1];
            for(int i = (2 * N) - 2; i >= 0; i--) {  // conveyor 벨트 한칸씩 회전
                conveyor[i + 1] = conveyor[i];
                if(i <= N -2) robot[i + 1] = robot[i];
            }
            conveyor[0] = last;
            robot[0] = false;

            // 2. 벨트에 로봇이 있으면 옆칸으로 옮길 수 있으면 옮기기
            for(int i = N - 1; i > 0; i--){    // 오래된 애부터
                if(robot[i]){
                    if(i == N - 1) {
                        robot[i] = false;
                        continue; // 맨 끝칸에 로봇있으면 내리기
                    }
                    // 칸에 로봇 있고 옆으로 옮길 수 있으면
                    if(!robot[i+1] && conveyor[i+1] > 0) {
                        robot[i] = false;
                        robot[i + 1] = true;  // 옮기고
                        conveyor[i + 1]--;    // 내구도 줄이기
                        if (conveyor[i + 1] == 0) k++;
                    }
                }
            }

            // 3. 벨트의 첫칸의 내구도가 0이 아니면 로봇 올리기
            if(conveyor[0] > 0){
                robot[0] = true;
                conveyor[0]--;
                if(conveyor[0] == 0) k++;
            }

            //4. 내구도 0인 칸의 개수가 K개 이상이라면 과정 종료.
            if(k >= K) break;
        }
        System.out.println(step);
    }

}
