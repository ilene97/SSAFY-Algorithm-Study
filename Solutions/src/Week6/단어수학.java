package Week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 단어수학 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        // G, 100
        // C, 10 + 1000 -> 1010
        // A, 10000
        // D, 100
        for(int n = 0; n < N; n++){
            String input = br.readLine();
            int len = input.length();
            int digit = len == 1 ? 1 : (int)Math.pow(10,len-1);
            for(int i = 0; i < len; i++){
                char c = input.charAt(i);
                //System.out.println(c + " " + digit);
                if(map.containsKey(c))
                    map.put(c, map.get(c) + digit);
                else
                    map.put(c, digit);
                digit /= 10;
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int sum = 0;
        int num = 9;
        for(Map.Entry<Character, Integer> entry : entryList){
            //System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
            sum += entry.getValue() * num;
            num--;
        }
        System.out.println(sum);
    }
}
