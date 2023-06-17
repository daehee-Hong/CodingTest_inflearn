package section7;

import java.util.Scanner;

public class 재귀함수_이진수출력 {
    /*
    10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용
    해서 출력해야 합니다.
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
        toBinary(n);
        return answer;
    }
    // 재귀함수는 stack 프레임을 사용 (매개, 지역, 복귀주소) 정보를 가지고 있음
    public static void toBinary(int n){
        // 2진수를 구할 때 몫이 0이 될때 까지 나누기
        if (n == 0) return;
        else {
            // n / 2 를 반복하여 나머지값을 출력함
            toBinary((n / 2));
            System.out.print(n%2 + " ");
        }

    }
}
