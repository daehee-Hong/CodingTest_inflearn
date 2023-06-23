package section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토_BFS {
    /*
    설명

    현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.

    토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.

    Image1.jpg

    창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,

    익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.

    하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,

    토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

    토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,

    며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.


    입력
    첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다. M은 상자의 가로 칸의 수,

    N 은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다.

    둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.

    즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.

    하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.

    정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.


    출력
    여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.

    만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,

    토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
    */
    static int n,m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static Queue<Point> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        for (int i = 0; i < m; i++) {
            StringTokenizer stToken = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stToken.nextToken());
                if (board[i][j] == 1) Q.offer(new Point(i, j));
            }
        }


        int L = BFS();
        boolean flag = false;

        // 토마토 탐색해서 0인값 찾으면 flag 설정
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag){
            System.out.println(-1);
        }else {
            System.out.println(L);
        }
    }


    public static int solution(int n){
        return 1;
    }

    public static int BFS(){
        int L = -1; // 처음에 토마트 1인값들 q에 이미 넣었으므로 -1
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point cur = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < m           // board의 범위 안이면서 0값이면 1로변경후 q저장
                        && ny >= 0 && ny < n
                        && board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        Q.offer(new Point(nx, ny));
                    }
                }
            }
            L++;
        }
        return L;
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
