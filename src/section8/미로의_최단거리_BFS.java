package section8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로의_최단거리_BFS {
    /*
    설명

    7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.

    출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.

    격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

    Image1.jpg

    위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.


    입력
    7*7 격자판의 정보가 주어집니다.


    출력
    첫 번째 줄에 경로의 가지수를 출력한다.
    */

    static int cnt = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        n = scanner.nextInt();
//        m = scanner.nextInt();

        board = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        // 시작지점 1로 초기화
        System.out.println(BFS(1, 1));
    }


    public static int solution(int n){
        return 1;
    }

    public static int BFS(int x, int y){
        Queue<미로의_최단거리_BFS.Point> Q = new LinkedList<>();
        Q.offer(new 미로의_최단거리_BFS.Point(x, y));
        board[1][1] = 1;
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                미로의_최단거리_BFS.Point cur = Q.poll();
                if (cur.x == 7 && cur.y == 7) return L;
                for (int j = 0; j < 4; j++) { // 현재 좌표에서 4방향 조회하여 0 인곳으로 이동 후 Q저장
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 1 && nx <= 7
                            && ny >= 1 && ny <= 7
                            && board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        Q.offer(new 미로의_최단거리_BFS.Point(nx, ny));
                    }
                }
            }
            L++;
        }
        return -1;
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
