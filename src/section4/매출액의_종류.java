package section4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 매출액의_종류 {
    /*
    설명

    현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를

    각 구간별로 구하라고 했습니다.

    만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면

    20 12 20 10 23 17 10

    각 연속 4일간의 구간의 매출종류는

    첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.

    두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.

    세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.

    네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.

    N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별

    매출액의 종류를 출력하는 프로그램을 작성하세요.


    입력
    첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.

    두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


    출력
    첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
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

        String result = solution(n, k, arr);
        System.out.println(result.trim());
    }

    public static String solution (int n, int k, int[] arr){
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        int lt = 0;
        // 각 매출기록 중 중복키의 개수를 구하기 위해서 map 선언
        HashMap<Integer, Integer> map = new HashMap<>();

        // sliding window 방식을 사용하기 위해서 lt, rt선언 후 n까지 반복
        for (int rt = 0; rt < n; rt++) {
            // map에 매출구간에서 매출종류를 구하고 cnt를 더한다.
            cnt++;
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            // cnt가 k이상이면 탐색구간을 확인했으므로 answer에 map.size를 저장한다.
            while (cnt >= k){
                answer.append(map.size()).append(" ");
                // map.get(arr[lt]) 값이 1 보다 크면 중복값이 있던다는 것이므로 삭제하지 말고 -1한다.
                if (map.get(arr[lt]) > 1){
                    map.put(arr[lt], map.get(arr[lt]) - 1);
                }else {
                    // 중복값이 없으면 삭제한다.
                    map.remove(arr[lt]);
                }
                // lt를 더하고 cnt를 뺀다.
                lt++;
                cnt--;
            }
        }

        return answer.toString();
    }
}
