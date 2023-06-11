package section3;

import java.util.Scanner;

public class 연속_부분수열 {
    /*
    설명

    N개의 수로 이루어진 수열이 주어집니다.

    이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.

    만약 N=8, M=6이고 수열이 다음과 같다면

    1 2 1 3 1 1 1 2

    합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.


    입력
    첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.

    수열의 원소값은 1,000을 넘지 않는 자연수이다.


    출력
    첫째 줄에 경우의 수를 출력한다.
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

    public static int solution (int[] arr, int m){
        int answer = 0;
        int sum = 0;
        // lt, rt의 간격의 합을 구해서 m 값과 비교
        int lt = 0;

        // lt는 냅두고 일단 rt 증가
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            // sum 값이 m 보다 크면 lt값을 증가시키고 arr[lt]를 뺀다.
            while (sum > m){
                sum -= arr[lt];
                lt++;
            }
            // sum 값이 m과 같으면 카운트
            if (sum == m){
                answer++;
            }
        }

        return answer;
    }
}
