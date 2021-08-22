package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bingo {
    static int[][] chulsu = new int[5][5];
    static int[] mc = new int[25];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp;
        for(int i = 0; i < 5; i++){
            temp = br.readLine().split(" ");
            for (int j = 0; j < 5; j++)
                chulsu[i][j] = Integer.parseInt(temp[j]);
        }
        for (int i = 0; i < 5; i++){
            temp = br.readLine().split(" ");
            for (int j = 0; j < 5; j++)
                mc[i*5 + j] = Integer.parseInt(temp[j]);
        }

        for (int i = 0; i < 25; i++){
            loop : for(int r = 0; r < 5; r++){
                for(int c = 0; c < 5; c++){
                    if(chulsu[r][c] == mc[i]){
                        chulsu[r][c] = 0;
                        if (checkRow(r) || checkCol(c) || (r==c && checkDia()) || (c==4-r && checkDia2()))
                            if(check3()){
                                System.out.println(i+1);
                                return;
                            }
                        break loop;
                    }
                }
            }
        }
    }

    private static boolean check3() {
        int cnt = 0;
        for(int i = 0; i < 5; i++){
            if(checkRow(i)) cnt++;
            if (checkCol(i)) cnt++;
        }
        if(checkDia()) cnt++;
        if (checkDia2()) cnt++;

        return cnt >= 3 ? true : false;
    }

    private static boolean checkRow(int row){
        for(int i = 0; i < 5; i++)
            if(chulsu[row][i] != 0)
                return false;
        return true;
    }

    private static boolean checkCol(int col){
        for(int i = 0; i < 5; i++)
            if(chulsu[i][col] != 0)
                return false;
        return true;
    }

    private static boolean checkDia(){
        for(int i = 0; i < 5; i++)
            if(chulsu[i][i] != 0)
                return false;
        return true;
    }

    private static boolean checkDia2(){
        for(int i = 0; i < 5; i++)
            if(chulsu[i][4 - i] != 0)
                return false;
        return true;
    }
}
