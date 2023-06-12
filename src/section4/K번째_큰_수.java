package section4;

import java.util.*;

public class K번째_큰_수 {
    /*
    설명

    현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.

    현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.

    기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.

    만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.


    입력
    첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.


    출력
    첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

//        int next2 = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = solution(arr, n, k);
        System.out.println(result);
    }

    public static int solution (int[] arr, int n, int k){
        int answer = -1;
        // 중복제거 및 정렬을 위해서 TreeSet 사용
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        // 카드 3장을 뽑아서 더한값을 얻기위해서 3중for문으로 모든 경우의 수 탐색
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        // k 번째 값을 for문으로 추출
        int cnt = 0;
        set.remove(143);
        for (Integer integer : set) {
            cnt++;
            if (cnt == k) {
                answer = integer;
                break;
            }
        }

        return answer;
    }
}
