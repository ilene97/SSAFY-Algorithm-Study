package Week3;

import java.util.Scanner;

public class SecretEmail {
    static int N;
    static int R, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        N = input.length();
        R = 1; C = N;

        findRC();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++)
                sb.append(input.charAt(j * R + i));
        }
        System.out.println(sb);
    }

    private static void findRC() {
        int tempR = 1;
        int tempC;
        while(true){
            tempR++;
            if(N % tempR == 0){
                tempC = N / tempR;
                if(tempR <= tempC) {
                    R = tempR;
                    C = tempC;
                }
                else return;
            }
        }
    }
}