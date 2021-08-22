package Week3;

import java.util.Scanner;

public class OXQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int len, answer, temp;
        char c;

        for(int t = 0; t < T; t++) {
            String input = sc.next();
            len = input.length();
            answer = 0;
            temp = 0;
            for (int i = 0; i < len; i++) {
                c = input.charAt(i);
                if (c == 'O') {
                    temp++;
                    answer += temp;
                }
                else {
                    temp = 0;
                }
            }
            System.out.println(answer);
        }
    }
}
