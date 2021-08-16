package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
    static int N, M;
    static int[][] box;
    static Queue<Pair> que = new LinkedList<>();
    static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};  // 상하좌우

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp;
        temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[1]);
        M = Integer.parseInt(temp[0]);
        box = new int[N][M];
        int totalTomato = 0, ripeTomato = 0;
        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(temp[j]);
                if (tomato == 1) {   // 익은 토마토면 큐에 넣기
                    que.offer(new Pair(i, j, 0));
                    totalTomato++; ripeTomato++;   // 전체 토마토 개수와 익은 토마토 개수 세기
                }
                else if(tomato == 0) totalTomato++;
                box[i][j] = tomato;
            }
        }
        br.close();

        /** main algorithm **/
        Pair cur = null;
        while(!que.isEmpty()){  // bfs
            cur = que.poll();

            for(int i = 0; i < 4; i++) {  // 4방향 탐색
                int curX = cur.x + dir[i][0];
                int curY = cur.y + dir[i][1];
                // 유효한 인덱스이고, 토마토가 안익었으면 탐색!
                if (isAvailable(curX, curY) && box[curX][curY] == 0) {
                    que.offer(new Pair(curX, curY, cur.day + 1));  // 큐에 넣고 day + 1
                    box[curX][curY] = 1; // 익은 토마토(1)로 표시
                    ripeTomato++;
                }
            }
        }

        /*  // 전체 box 순회해서 확인
        for(int i = 0; i < N; i++)   // 안익은 토마토(0) 있으면 -1 출력
            for(int j = 0 ; j < M; j++)
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

         */

        // 토마토 개수로 확인 이게 더 오래걸림...
        if (totalTomato == ripeTomato)  // 모든 토마토가 익었으면 day 출력
            System.out.println(cur.day);  // 가장 마지막 토마토가 가장 마지막 날에 익은 토마토
        else // 덜익은 토마토가 있으면 -1 출력
            System.out.println(-1);
    }

    static boolean isAvailable(int r, int c){
        if(0 <= r && r < N && 0 <= c && c < M) return true;
        return false;
    }
}

class Pair{
    int x;
    int y;
    int day;

    Pair(int x, int y, int day){
        this.x = x;
        this.y = y;
        this.day = day;
    }
}