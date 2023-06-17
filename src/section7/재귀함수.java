package section7;

import java.util.Arrays;
import java.util.Scanner;

public class 재귀함수 {
    /*
    자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int m = scanner.nextInt();
////
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        int k = scanner.nextInt();
//        int[] list = new int[k];
//        for (int l = 0; l < k; l++) {
//            list[l] = scanner.nextInt();
//        }
        int result = solution(n);
    }

    public static int solution (int n){
        int answer = 0;
        check(n);
        return answer;
    }
    // 재귀함수는 stack 프레임을 사용 (매개, 지역, 복귀주소) 정보를 가지고 있음
    public static void check(int n){
        if (n == 0) return;
        check(n - 1);
        // 재귀 함수 밑의 코드는 재귀가 끝날때까지 대기하다가 나중에 실행되므로
        // n == 0 으로 리턴되는 순간 stack 밑의 상단부터 출력된다.
        // 그래서 반대로 출력된다.
        System.out.print(n + " ");
    }
}
