package Week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 파이프옮기기1 {
    static int N;
    static int[][] house;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N][N];
        String[] temp;
        for(int i = 0; i < N; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                house[i][j] = Integer.parseInt(temp[j]);
        }

        // type : 파이프 가로0, 세로1, 대각선2
        dfs(0, 1, 0);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int type) {
        if(r == N-1 && c == N-1) {
            answer++;
            return;
        }

        switch (type){
            case 0:// 가로
                if(isAvailable(r, c+1) && house[r][c+1] != 1)
                    dfs(r, c+1, 0); // 가로
                break;
            case 1: // 세로
                if (isAvailable(r+1, c) && house[r+1][c] != 1)
                    dfs(r+1, c, 1); // 세로
                break;
            case 2: // 대각선
                if(isAvailable(r, c+1) && house[r][c+1] != 1)
                    dfs(r, c+1, 0); // 가로
                if (isAvailable(r+1, c) && house[r+1][c] != 1)
                    dfs(r+1, c, 1); // 세로
                break;
        }

        if(isAvailable(r+1, c+1) && house[r][c+1] != 1 && house[r+1][c] != 1 && house[r+1][c+1] != 1)
            dfs(r+1, c+1, 2); // 대각선
    }

    private static boolean isAvailable(int r, int c) {
        if( 0 <= r && r < N && 0 <= c && c < N ) return true;
        return false;
    }

}
