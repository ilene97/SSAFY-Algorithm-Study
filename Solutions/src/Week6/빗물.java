package Week6;

import java.util.Scanner;

public class 빗물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int W = sc.nextInt();
        int[] blocks = new int[W];

        // 인풋 받으면서 가장 높은 블럭 중에 가장 오른 쪽에 있는 애 찾기
        int highestIdx = -1;
        int highest = 0;
        for(int i = 0; i < W; i++) {
            blocks[i] = sc.nextInt();
            if(blocks[i] >= highest){
                highest = blocks[i];
                highestIdx = i;
            }
        }

        int water = 0;

        int leftL = 0;
        int leftR = 0;
        while(leftL < highestIdx){
            leftR++;
            if(blocks[leftR] >= blocks[leftL]){
                for(int i = leftL+1; i < leftR; i++)
                    water += blocks[leftL] - blocks[i];
                leftL = leftR;
            }
        }
        /*
              *
        *  *  *  *
        ** ** ****
        **********
        */

        int rightL = W-1;
        int rightR = W-1;
        while(highestIdx < rightR){
            rightL--;
            if(blocks[rightL] >= blocks[rightR]){
                for(int i = rightL+1; i < rightR; i++)
                    water += blocks[rightR] - blocks[i];
                rightR = rightL;
            }
        }

        System.out.println(water);
    }
}
