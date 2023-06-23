package section8;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬나라_아일랜드_BFS {
    /*
   설명

    N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.

    각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.

    섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.

    Image1.jpg

    만약 위와 같다면 섬의 개수는 5개입니다.


    입력
    첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.

    두 번째 줄부터 격자판 정보가 주어진다.


    출력
    첫 번째 줄에 섬의 개수를 출력한다.
   */
    static int n,m;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] board;

    static int cnt = 0;
    static Queue<Point> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer stToken = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stToken.nextToken());
            }
        }

        solution();
        System.out.println(cnt);

    }


    public static void solution(){
        // board에서 값이 1이면 cnt하고 해당좌표를 DFS에 넘긴다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // board의 현재 좌표
                int cur = board[i][j];
                if (cur == 1) {
                    cnt++;
                    Q.offer(new Point(i, j));
                    board[i][j] = 0;
                    BFS();
                }
            }
        }
    }
    public static void BFS(){
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point cur = Q.poll();
                // 넘어온 좌표로 8방향의 갈수있는 값을 전부 0으로 바꾼다.
                for (int k = 0; k < 8; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    if (nx >= 0 && nx < n
                            && ny >= 0 && ny < n
                            && board[nx][ny] == 1){
                        board[nx][ny] = 0;
                        Q.offer(new Point(nx, ny));
                    }
                }
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
