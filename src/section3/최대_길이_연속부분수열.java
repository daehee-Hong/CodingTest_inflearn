package section3;

import java.util.Scanner;

public class 최대_길이_연속부분수열 {
    /*
    설명

    0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.

    만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면

    1 1 0 0 1 1 0 1 1 0 1 1 0 1

    여러분이 만들 수 있는 1이 연속된 연속부분수열은

    Image1.jpg

    이며 그 길이는 8입니다.


    입력
    첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.

    두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.


    출력
    첫 줄에 최대 길이를 출력하세요.
  */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next1 = scanner.nextInt();
        int next2 = scanner.nextInt();

        int[] arr = new int[next1];
        for (int i = 0; i < next1; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = solution(arr, next1, next2);
        System.out.println(result);
    }

    public static int solution (int[] arr,int n,  int k){
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            // arr[rt]가 0이면 cnt 추가
            if (arr[rt] == 0) {
                cnt++;
            }
            // cnt가 k 보다 크면 0을 1로 바꿀수 있는 횟수 초과
            while(cnt>k){
                // arr[lt] lt를 증가시키면서 0이면 cnt값을 감소시킨다.
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            // 기존 answer 값과 rt-lt+1의 값을 비교하여 최대값으로 대체한다.
            answer = Math.max(answer, rt-lt+1);
        }

        return answer;
    }
}
