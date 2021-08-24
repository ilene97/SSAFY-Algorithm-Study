package Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Guard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int garo = Integer.parseInt(temp[0]);
        int sero = Integer.parseInt(temp[1]);
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer[]> dirMap = new HashMap<>();
        dirMap.put(1, new Integer[] {garo, sero});
        dirMap.put(2, new Integer[] {sero, garo});
        dirMap.put(3, new Integer[] {garo, sero});
        dirMap.put(4, new Integer[] {sero, garo});

        ArrayList<int[]> stores = new ArrayList<>();
        int my_dir = 0, my_loc = 0;
        for(int n = 0; n <= N; n++){
            temp = br.readLine().split(" ");
            int dir = Integer.parseInt(temp[0]);
            int loc = Integer.parseInt(temp[1]);
            if(dir == 3) dir = 2;
            else if(dir == 2) dir = 3;
            if(n == N){
                my_dir = dir;
                my_loc = loc;
                continue;
            }
            stores.add(new int[] {dir, loc});
        }


        int sum = 0;
        for(int i = 0; i < N; i++){
            int[] store = stores.get(i);
            if(store[0] == my_dir)   // 나랑 같은 방향
                sum += Math.abs(my_loc - store[1]);
            else if(Math.abs(store[0] - my_dir) == 2) // 나랑 맞은편
                sum += (Math.min(my_loc + store[1], dirMap.get(my_dir)[0] * 2 - my_loc - store[1]) + dirMap.get(my_dir)[1]);
            else{       // 내 옆벽
                if((my_dir == 1 && store[0] == 2 )|| (my_dir == 2 && store[0] == 1))
                    sum += my_loc + store[1];
                else if((my_dir == 3 && store[0] == 4) || (my_dir == 4 && store[0] == 3))
                    sum += (dirMap.get(my_dir)[0] - my_loc) + (dirMap.get(store[0])[0] - store[1]);
                else if((my_dir == 3 && store[0] == 2)||(my_dir == 4 && store[0] == 1))
                    sum += my_loc + (dirMap.get(store[0])[0] - store[1]);
                else
                    sum += (dirMap.get(my_dir)[0] - my_loc) + store[1];
            }
        }
        System.out.println(sum);

    }
}
