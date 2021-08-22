package Week3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Rest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rests = new int[42];

        int num;
        for(int i = 0; i < 10; i++){
            num = sc.nextInt();
            rests[num%42] = 1;
        }
        System.out.println(IntStream.of(rests).sum());
    }
}
