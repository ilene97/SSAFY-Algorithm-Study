package Week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Warehouse_Polygon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Column> columns = new ArrayList<>();
        int highest = 0, L, H;
        for(int i = 0; i < N; i++){
            L = sc.nextInt();
            H = sc.nextInt();
            highest = Math.max(highest, H); // 가장 높은 기둥의 높이 저장
            columns.add(new Column(L, H));
        }
        Collections.sort(columns);  // L 순서대로 정렬
        int highestIdx = 0;
        for(int i = 0; i < N; i++){
            if(columns.get(i).H == highest){  // 가장 첫번째로 나오는 가장 높은 기둥의 인덱스 구하기
                highestIdx = i;
                break;
            }
        }

        int area = 0;
        // 왼쪽부터 탐색
        Column cur = columns.get(0);
        for(int i = 0; i <= highestIdx; i++){
            Column next = columns.get(i);
            if(next.H >= cur.H){             // 현재 높이보다 높은 기둥을 만나면
                area += (next.L - cur.L)* cur.H;    // 그때까지의 면적을 구하고
                cur = next;                 // 높은 기둥으로 현재 기둥을 바꾼다.
            }
            if(i == highestIdx)
                area += highest;
        }

        // 오른쪽부터 탐색
        cur = columns.get(N-1);
        for(int i = N-1; i >= highestIdx; i--){
            Column next = columns.get(i);
            if(next.H >= cur.H){     // 현재 높이보다 높은 기둥을 만나면
                area += (cur.L - next.L)* cur.H;    // 그때까지의 면적을 구하고
                cur = next; // 높은 기둥으로 현재 기둥을 바꾼다.
            }
        }

        System.out.println(area);
    }

    static class Column implements Comparable<Column>{
        int L;
        int H;

        Column(int l, int h) {
            L = l;
            H = h;
        }
        @Override
        public int compareTo(Column o) {
            return this.L - o.L;
        }
    }
}
