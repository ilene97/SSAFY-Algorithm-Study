import jdk.swing.interop.DropTargetContextWrapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeSolution {
    static int[][] board;
    static int N;
    static int[] dir;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\SSAFY\\workspace\\Algorithm_Study\\Study-Week1\\src\\input3.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // input
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];  // 빈 인덱스 0
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            String[] temp = br.readLine().split(" ");
            board[Integer.parseInt(temp[0]) - 1][Integer.parseInt(temp[1]) - 1] = 2; // 사과 2
        }
        int L = Integer.parseInt(br.readLine());
        String[][] commands = new String[L][2];
        for(int i = 0; i < L; i++)
            commands[i] = br.readLine().split(" ");

        /** main algorithm **/
        int sec = 0;
        int[] head = {0, 0};
        int[] tail = {0, 0};
        Queue<int[]> tailDir = new LinkedList<>();
        board[0][0] = 1; // 뱀 1

        int commNum = 0;
        int commSec = Integer.parseInt(commands[commNum][0]);
        String command = commands[commNum][1];
        dir = new int[] {0, 1};

        int nextHeadRow, nextHeadCol;
        while(true){
            sec++;
            // nextHeadRow, nextHeadCol 구하기 (방향에 따라 다르니까)
            nextHeadRow = head[0] + dir[0];
            nextHeadCol = head[1] + dir[1];

            // nextHead가 inavailable -> stop
            if(!isAvailable(nextHeadRow, nextHeadCol)) break;

            // 그 칸에 사과가 있으면 2->1, head 바꾸기
            if(board[nextHeadRow][nextHeadCol] == 2){
                board[nextHeadRow][nextHeadCol] = 1;
                head[0] = nextHeadRow;
                head[1] = nextHeadCol;
                tailDir.offer(new int[]{dir[0], dir[1]});
            }
            // 사과가 없으면 헤드: 0 -> 1, 헤드 바꾸기, tail 1->0, 테일 바꾸기
            else{
                board[nextHeadRow][nextHeadCol] = 1;
                head[0] = nextHeadRow;
                head[1] = nextHeadCol;
                tailDir.offer(new int[]{dir[0], dir[1]});

                board[tail[0]][tail[1]] = 0;
                int[] temp = tailDir.poll();
                tail[0] += temp[0];
                tail[1] += temp[1];
            }

            if(sec == commSec){
                dir = setDir(command, dir);
                commNum++;
                if(commNum < L){
                    commSec = Integer.parseInt(commands[commNum][0]);
                    command = commands[commNum][1];
                }
            }
        }

        // output
        sb.append(sec);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // row: 0 1 0 -1 0
    // col: 1 0 -1 0 1
    private static int[] setDir(String command, int[] dir) {
        int[] temp;
        switch (command){
            case("L"):
                temp = new int[] {dir[1] * -1, dir[0]};
                break;
            case("D"):
                temp = new int[] {dir[1], dir[0] * -1};
                break;
            default:
                temp = new int[] {0, 0};
        }
        return temp;
    }

    private static boolean isAvailable(int row, int col) {
        if(0 <= row && row < N && 0 <= col && col < N)
            if(board[row][col] != 1)
                return true;
        return false;
    }
}