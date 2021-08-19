package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Beer {
    static int n;
    static Pair home, fest;
    static Pair[] nodes;
    static Queue<Integer> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            // input
            int n = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            home = new Pair(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            nodes = new Pair[n+2];
            nodes[0] = home;
            for(int i = 1; i <= n; i++){
                temp = br.readLine().split(" ");
                nodes[i] = new Pair(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            }
            temp = br.readLine().split(" ");
            fest = new Pair(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            nodes[n+1] = fest;

            que.offer(0);
            int cur;
            boolean arrived = false;
            while(!que.isEmpty()){
                cur = que.poll();
                if(getDist(cur, n+1) <= 1000){
                    arrived = true;
                    break;
                }

                for(int i = 1; i <= n; i++){
                    int dist = getDist(i, cur);
                    if(0 < dist && dist <= 1000)
                        que.offer(i);
                }
            }
            if(arrived) System.out.println("happy");
            else System.out.println("sad");
            que.clear();
        }
    }

    public static int getDist(int a, int b){
        return Math.abs(nodes[a].x - nodes[a].x) + Math.abs(nodes[b].y - nodes[b].y);
    }

    public static class Pair{
        int x, y;

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}
