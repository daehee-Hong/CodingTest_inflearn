package section8;

import java.util.Scanner;

public class 조합의_경우수_메모이제이션 {
    /*
   설명

    Image1.jpg로 계산합니다.

    하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.

    Image1.jpg


    입력
    첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.


    출력
   */
    //static int n, m;

    static int[][] dy = new int[35][35];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        ch = new int[n];
//        pm = new int[m];

        System.out.println(DFS(n, r));

    }


    public static int solution(int n){
        return 1;
    }

    public static int DFS(int n, int r){
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        // 4,2   4,3   3
        else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
}
