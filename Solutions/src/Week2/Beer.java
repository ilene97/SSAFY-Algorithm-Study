package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 틀림
public class Beer {
    static int n;
    static Pair[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            // input
            n = Integer.parseInt(br.readLine());
            nodes = new Pair[n+2];
            visited = new boolean[n+2];
            Queue<Pair> que = new LinkedList<>();
            String[] temp;
            for(int i = 0; i < n + 2; i++){
                temp = br.readLine().split(" ");
                nodes[i] = new Pair(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            }

            // bfs
            Pair start = nodes[0];
            Pair end = nodes[n+1];
            que.offer(start);
            boolean arrived = false;

            while(!que.isEmpty()){
                Pair cur = que.poll();

                if(cur.equals(end)){
                    arrived = true;
                    break;
                }
                for(int i = 1; i < n + 2; i++){
                    if(visited[i] == false && getDist(nodes[i], cur) <= 1000) {
                        que.offer(nodes[i]);
                        visited[i] = true;
                    }
                }
            }
            if(arrived) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    public static int getDist(Pair a, Pair b){
        return Math.abs(a.x - a.x) + Math.abs(b.y - b.y);
    }

    public static class Pair{
        int x, y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}
