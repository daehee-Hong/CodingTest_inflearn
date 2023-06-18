package section7;

import java.util.Scanner;

public class 피보나치_수열_재귀 {
    /*
    1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는
    수열이다.
    2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면
    된다.
    */
    static int[] fiboList;

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
        fiboList = new int[n + 1];
        //
        fibonacci(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fiboList[i] + " ");
        }

        return answer;
    }
    // 재귀함수는 stack 프레임을 사용 (매개, 지역, 복귀주소) 정보를 가지고 있음
    public static int fibonacci(int n){
        // 이미 구한 값이면 재귀하지말고 리턴 (메모이제이션)
        if (fiboList[n] > 0) return fiboList[n];
        // 1항이나 2항일 때 1 저장
        if (n <= 1) return fiboList[n] = 1;
        else if (n == 2) return fiboList[n] = 1;
        else {
            // 이전항과 그 이전항을 더한 값을 리스트에 저장
            return fiboList[n] = fibonacci(n - 2) + fibonacci(n - 1);
        }
    }
}
