package Week3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CroatiaAlpabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        Set<String> croatia = new HashSet<>();
        croatia.add("c=");
        croatia.add("c-");
        croatia.add("dz=");
        croatia.add("d-");
        croatia.add("lj");
        croatia.add("nj");
        croatia.add("s=");
        croatia.add("z=");

        int i = 0, len = input.length();
        String token = null;
        int answer = 0;
        while(i < len){
            if(i <= len - 2)
                token = input.substring(i, i + 2);
            if(i <= len - 3 && token.equals("dz"))
                token = input.substring(i, i + 3);
            // System.out.println(token);
            if(croatia.contains(token)){
                if(token.equals("dz=")) i += 3;
                else i += 2;
                answer++;
                continue;
            }
            i++;
            answer++;
        }
        System.out.println(answer);
    }
}
