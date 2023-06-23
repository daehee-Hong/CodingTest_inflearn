package section8;

import java.util.Scanner;

public class 조합_구하기 {
    /*
    1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그
    램을 작성하세요.

    ▣ 입력설명
    첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.

    ▣ 출력설명
    첫 번째 줄에 결과를 출력합니다.
    출력순서는 사전순으로 오름차순으로 출력합니다.
    */
    static int n, m;

    static int[] pm;
    static int[] ch;
    static int cnt = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
        ch = new int[n];
        pm = new int[m];

        DFS(0, 1);

    }


    public static int solution(int n){
        return 1;
    }

    public static void DFS(int L, int start){
        if (L == m){
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();

        }else {
            for (int i = start; i <= n; i++) {
                if (ch[L] == 0){
                    ch[L] = 1;
                    pm[L] = i;
                    DFS(L + 1, i + 1);
                    ch[L] = 0;
                }
            }
        }
    }
}
