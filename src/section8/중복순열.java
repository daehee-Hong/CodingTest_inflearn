package section8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 중복순열 {
    /*
    1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
    하는 방법을 모두 출력합니다
    */
    static int n, m;
    static int max = 0;
    static int answer = 0;
    static int[] pm;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pm = new int[m];

        DFS(0);
    }


    public static int solution(int n){
        return 1;
    }

    public static void DFS(int L){
        // m 번째 경우의 수까지 반복했는지 확인
        if (L == m){
            System.out.println(Arrays.toString(pm));
        }else {
            // list에 n번 반복하여 n까지의 값을 저장하고 L ++;
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }

}
