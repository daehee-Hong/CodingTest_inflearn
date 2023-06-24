package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 피자_배달_거리_DFS {
    /*
   설명

    N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.

    각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.

    행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.

    도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는

    피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.

    집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.

    예를 들어, 도시의 지도가 아래와 같다면

    Image1.jpg

    (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.

    최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.

    도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.

    시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.

    도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.


    입력
    첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.

    둘째 줄부터 도시 정보가 입력된다.


    출력
    첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.
   */
    static int n,m, len, answer = Integer.MAX_VALUE;
    static List<Point> hs = new ArrayList<>();
    static List<Point> pz = new ArrayList<>();;
    static int[][] board;
    static int[] combi;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stToken = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int xy = Integer.parseInt(stToken.nextToken());
                board[i][j] = xy;
                if (xy == 1) hs.add(new Point(i, j));
                else if (xy == 2) pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];
        DFS(0,0);
        System.out.println(answer);

    } // len C m


    public static void solution(){

    }

    public static void DFS(int L, int s){
        // 조합 경우 찾기 예) 6개중 4개를 조합할 수 있는 경우 15개가 나옴
        if (L == m){
            // 조합 하나 완성
            int sum = 0;
            for (Point h : hs){ // 집 하나 가져옴
                int dis = Integer.MAX_VALUE;
                for (int i : combi){    // combi는 인덱스 값이 들어있기 때문에 pz에서 get으로 꺼냄
                    // 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2|
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis; // 집의 피자 배달거리를 sum에 더해서 도시에 피자배달거리를 구한다.
            }
            answer = Math.min(answer, sum);
        }else {
            // 0 부터 pz의 길이 만큼 반복 ()
            for (int i = s; i < len; i++){
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
