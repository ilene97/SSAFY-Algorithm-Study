package Week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Beer2 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Testcase = Integer.parseInt(br.readLine());

        for (int t = 0; t < Testcase; t++) {
            int N = Integer.parseInt(br.readLine());
            LOCATION[] location = new LOCATION[N + 2];
            int[] check = new int[N + 2];
            Queue<LOCATION> q = new LinkedList<LOCATION>();
            boolean success = false;
            String[] str;
            for (int i = 0; i < N + 2; i++) {
                str = br.readLine().split(" ");
                location[i] = new LOCATION(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }

            LOCATION start = location[0];
            LOCATION end = location[N + 1];
            q.add(start);

            while (!q.isEmpty()) {
                LOCATION current = q.poll();
                if(current.equals(end)){
                    success = true;
                    break;
                }
                for (int i = 1; i < N + 2; i++) {
                    if (check[i] == 0 &&Math.abs(current.x - location[i].x) + Math.abs(current.y - location[i].y) <= 1000) {
                        q.add(location[i]);
                        check[i] = 1;
                    }
                }
            }
            if(success)
                System.out.println("happy");

            else
                System.out.println("sad");

        }
    }
}

class LOCATION {
    int x;
    int y;

    LOCATION(int x, int y) {
        this.x = x;
        this.y = y;
    }
}