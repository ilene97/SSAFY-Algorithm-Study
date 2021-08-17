package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumOfIslands {
    static int W, H;
    static int[][] map;
    static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1},{-1, -1},{-1, 1},{1, -1},{1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp;
        while((temp = br.readLine().split(" ")) != null){
            // input
            W = Integer.parseInt(temp[0]);
            H = Integer.parseInt(temp[1]);
            if(W == 0 && H == 0) break;   // 0 0 입력되면 끝내기

            map = new int[H][W];
            for(int h = 0; h < H; h++){
                temp = br.readLine().split(" ");
                for(int w = 0; w < W; w++)
                    map[h][w] = Integer.parseInt(temp[w]);
            }

            /** main algorithm **/
            int cnt = 0;
            for(int h = 0; h < H; h++){
                for(int w = 0; w < W; w++)
                    if(map[h][w] == 1) {    // 땅이면 dfs
                        dfs(h, w);
                        cnt++;              // 섬 개수 하나 증가
                    }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int h, int w) {
        map[h][w] = -1;     // visit 표시는 -1로 함
        for(int i = 0; i < dir.length; i++){
            int nextH = h + dir[i][0], nextW = w + dir[i][1];
            if(isAvailable(nextH, nextW) && map[nextH][nextW] == 1)  // 방문하지 않은 땅이면
                dfs(nextH, nextW);                                  // 추가 탐색
        }
    }

    private static boolean isAvailable(int r, int c){
        if(0 <= r && r < H && 0 <= c && c < W)
            return true;
        return false;
    }
}
