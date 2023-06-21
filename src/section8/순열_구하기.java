package section8;

import java.util.*;
import java.util.stream.Collectors;

public class 순열_구하기 {
    /*
    10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합
    니다
    */
    static int n, m;

    static int[] pm;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        pm = new int[m];
        DFS(0, arr);

    }


    public static int solution(int n){
        return 1;
    }

    public static void DFS(int L, int[] arr){
        if (L == m){
            if (pm[0] == pm[1]) return;
            System.out.println(pm[0] + " " + pm[1]);
        }else {
            for (int i = 0; i < n; i++) {
                pm[L] = arr[i];
                DFS(L + 1, arr);
            }
        }
    }

}
