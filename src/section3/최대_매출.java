package section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 최대_매출 {
    /*
    설명

    현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.

    만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면

    12 1511 20 2510 20 19 13 15

    연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.

    여러분이 현수를 도와주세요.


    입력
    첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.

    두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


    출력
    첫 줄에 최대 매출액을 출력합니다.
  */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next1 = scanner.nextInt();
        int next2 = scanner.nextInt();

        int[] arr = new int[next1];
        for (int i = 0; i < next1; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = solution(arr, next2);
        System.out.println(result);
    }

    public static int solution (int[] arr, int k){
        int answer = 0;
        int sum = 0;
        // 처음 k개의 연속된 값을 sum에 저장
        for (int i = 0; i < k; i++){
            sum += arr[i];
        }
        // answer에 sum값을 저장 (max값)
        answer = sum;

        // i = k 로 이미 sum한 값 다음 부터 반복
        for (int i = k; i < arr.length; i++) {
            sum += arr[i];      // sum한 값 다음 값을 더하고
            sum -= arr[i-k];    // sum한 값 첫번째 값을 뺀다.

            // sum값이 최대값인지 확인한다.
            if (answer < sum){
                answer = sum;
            }

        }

        return answer;
    }
}
