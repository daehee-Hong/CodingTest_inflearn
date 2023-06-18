package section7;

import java.util.Scanner;

public class 팩토리얼 {
    /*
    자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
    예를 들어 5! = 5*4*3*2*1=120입니다.
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
        System.out.print(factorial(n));
        return answer;
    }
    // 재귀함수는 stack 프레임을 사용 (매개, 지역, 복귀주소) 정보를 가지고 있음
    public static int factorial(int n){
        if (n <= 1) return 1;
        else {
            // 5,4,3,2,1 반복하고 ((((1 * 2) * 3) * 4) * 5) 이 리턴된다.
            return factorial(n - 1) * n;
        }

    }
}
