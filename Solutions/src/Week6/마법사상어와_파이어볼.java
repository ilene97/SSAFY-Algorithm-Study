package Week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 마법사상어와_파이어볼 {
    static int N, M, K;
    static ArrayList<FireBall> fireBalls = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        K = Integer.parseInt(temp[2]);
        int[] param = new int[5];
        for(int i = 0; i < M; i++){
            temp = br.readLine().split(" ");
            for(int j = 0; j < 5; j++)
                param[j] = Integer.parseInt(temp[j]);
            fireBalls.add(new FireBall(param[0], param[1], param[2], param[3], param[4]));
        }
    }

    public static class FireBall{
        int r, c;
        int m, d, s;

        FireBall(int r,int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
