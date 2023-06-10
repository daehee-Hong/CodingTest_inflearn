package section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class 두_배열_합치기 {
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

        int[] arr = new int[next1];
        for (int i = 0; i < next1; i++) {
            arr[i] = scanner.nextInt();
        }

        int next2 = scanner.nextInt();

        int[] arr2 = new int[next2];
        for (int i = 0; i < next2; i++) {
            arr2[i] = scanner.nextInt();
        }
        List<Integer> result = solution(arr, arr2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> solution (int[] arr, int[] arr2){
        List<Integer> answer = new ArrayList<>();
        int n = arr.length;
        int m = arr2.length;

        int p1 = 0;
        int p2 = 0;
        // p1, p2 가 &&로 true 상태이다가 하나라도 배별을 넘어가면 flase
        while (p1 < n && p2 < m){
            if (arr[p1] > arr2[p2]){
                answer.add(arr2[p2]);
                p2++;
            }else {
                answer.add(arr[p1]);
                p1++;
            }
        }
        // p1이 n 보다 작으면 남은 값이 있으므로 남은값 저장
        while (p1<n) {
            answer.add(arr[p1]);
            p1++;
        }

        // p2이 n 보다 작으면 남은 값이 있으므로 남은값 저장
        while (p2<m) {
            answer.add(arr2[p2]);
            p2++;
        }
        System.out.println(answer);

        return answer;
    }
}
