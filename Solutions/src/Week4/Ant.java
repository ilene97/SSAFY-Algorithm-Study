package Week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ant {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int curX = Integer.parseInt(st.nextToken());
        int curY = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        int sumX = curX + T;
        int sumY = curY + T;

        if((sumX / w) % 2 == 0)
            sb.append(sumX % w);
        else
            sb.append(w - (sumX % w));

        sb.append(" ");

        if((sumY/h) % 2 == 0)
            sb.append(sumY % h);
        else
            sb.append((h - (sumY % h)));

        System.out.println(sb);

        /*
        int dirX = 1, dirY = 1;
        for(int t = 0; t < T; t++){
            curX += dirX;
            curY += dirY;

            // 모서리인 경우
            if((curX == 0 && curY == 0)||(curX == 0 && curY == h)||(curX == w && curY == 0)||(curX == w && curY == h)){
                dirX *= -1;
                dirY *= -1;
            }
            else if (curX == 0 || curX == w) // 양 옆 벽인 경우
                dirX *= -1;
            else if(curY == 0 || curY == h) // 위아래 벽인 경우
                dirY *= -1;

        }
        System.out.println(curX + " " + curY);
        */
    }
}
