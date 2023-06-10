package section2;

import java.util.Arrays;
import java.util.Scanner;

public class 멘토링 {
    /*
    설명

    현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.

    멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.

    선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.

    만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.

    M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.


    입력
    첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.

    두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.

    만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.


    출력
    첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
   */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next1 = scanner.nextInt();
        int next2 = scanner.nextInt();
        int[][] arr = new int[next2][next1];
        for (int i = 0; i < next2; i++) {
            for (int j = 0; j < next1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int arr2 = solution(arr);
        System.out.print(arr2);
    }

    public static int solution (int[][] arr){
        int answer = 0;
        int m = arr.length;     // 테스트 수
        int n = arr[0].length;  // 학생 수

        // 처음 이중 for 문은 배열의 모든 값을 순회하기 위해서 사용
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                // 내부의 이중 for 문은 m=테스트수, s=학생수로 돌려야한다.
                for (int k = 0; k < m; k++) {
                    int pi=0, pj=0;
                    for (int s = 0; s < n; s++) {
                        // i가 멘토, j가 멘티로 한다.
                        if (arr[k][s] == i+1) pi=s;
                        if (arr[k][s] == j+1) pj=s;
                    }
                    // (pi)멘토가 (pj)멘티보다 작아야 등수가 낮은 것이므로 카운트한다.
                    if (pi<pj) cnt++;
                }
                // 멘토가 멘티보다 큰 카운트가 테스트 수와 같으면 answer을 더한다.
                if (cnt==m){
                    answer++;
                }
            }
        }

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

        return answer;
    }
}
