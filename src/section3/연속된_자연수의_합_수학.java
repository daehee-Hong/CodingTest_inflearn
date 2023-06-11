package section3;

import java.util.Scanner;

public class 연속된_자연수의_합_수학 {
    /*
    설명

    N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.

    만약 N=15이면

    7+8=15

    4+5+6=15

    1+2+3+4+5=15

    와 같이 총 3가지의 경우가 존재한다.


    입력
    첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.


    출력
    첫 줄에 총 경우수를 출력합니다.
  */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next1 = scanner.nextInt();
//        int next2 = scanner.nextInt();
//
//        int[] arr = new int[next1];
//        for (int i = 0; i < next1; i++) {
//            arr[i] = scanner.nextInt();
//        }

        int result = solution(next1);
        System.out.println(result);
    }

    public static int solution (int n){
        int answer = 0;
        // cnt 연속된 자연수의 개수
        int cnt = 0;
        // w
        n--;
        while (n > 0){
            // 연속된 자연수의 수를 2개부터 확인하기 위해서 ++
            cnt++;
            n = n - cnt;
            if (n % cnt == 0) answer++;
        }

        return answer;
    }
}
