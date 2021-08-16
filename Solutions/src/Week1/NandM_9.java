package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class NandM_9 {
    static int N, M;
    static int[] input, numbers;
    static ArrayList<int[]> answers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        input = new int[N];
        numbers = new int[M];
        temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(temp[i]);

        Arrays.sort(input);
        perm(0,0);

        //output
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answers.size(); i++){
            for(int j = 0; j < M; j++){
                sb.append(answers.get(i)[j]).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void perm(int cnt, int flag){
        if(cnt == M){
            for(int i = 0; i < answers.size(); i++) {
                if (Arrays.equals(answers.get(i), numbers)) return;
            }
            answers.add(numbers.clone());
            return;
        }

        for(int i = 0; i < N; i++){
            if((flag & 1 << i) != 0) continue;
            numbers[cnt] = input[i];
            perm(cnt+1, flag | 1 << i);
        }
    }
}