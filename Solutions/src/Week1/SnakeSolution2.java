package Week1;

import java.util.*;
        import java.io.IOException;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;

public class SnakeSolution2 {
    private static int[] dirX = {1, 0, -1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    public static void main(String[] args){
        int[][] board;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, String> dirMap = new HashMap<>();

        // Input
        try {
            int N = Integer.parseInt(br.readLine());
            board = new int[N][N];

            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < K; i++) {
                String[] temp = br.readLine().split(" ");
                board[Integer.parseInt(temp[0]) - 1][Integer.parseInt(temp[1]) - 1] = -1;
            }

            int L = Integer.parseInt(br.readLine());
            for (int i = 0; i < L; i++) {
                String[] temp = br.readLine().split(" ");
                dirMap.put(Integer.parseInt(temp[0]), temp[1]);
            }

            // Initial Position = (0, 0)
            int headX = 0;
            int headY = 0;
            int headDir = 0;
            int snakeSize = 1;

            int time = 0;
            while (true) {
                // Update Snake Direction
                if (dirMap.get(time) != null) {
                    if (dirMap.get(time).equals("D")) {
                        headDir++;
                        if (headDir > 3) headDir = 0;
                    } else if (dirMap.get(time).equals("L")) {
                        headDir--;
                        if (headDir < 0) headDir = 3;
                    }
                }

                // Set time
                time++;

                // Move Snake
                headX += dirX[headDir];
                headY += dirY[headDir];

                // Check if the new position is out of bound
                if (headY >= N || headY < 0 || headX >= N || headX < 0) {
                    break;
                }

                // Check if there exist the collision
                if (board[headY][headX] > 0 && board[headY][headX] >= time - snakeSize) {
                    if(time > 1) break;
                }

                // If the apple is in the new position
                if (board[headY][headX] == -1) {
                    snakeSize++;
                }
                board[headY][headX] = time;
            }

            System.out.println(time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}