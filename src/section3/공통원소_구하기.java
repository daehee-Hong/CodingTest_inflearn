package section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 공통원소_구하기 {
    /*
    설명

    A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


    입력
    첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.

    두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

    세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.

    네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

    각 집합의 원소는 1,000,000,000이하의 자연수입니다.


    출력
    두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
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
        Arrays.sort(arr);
        Arrays.sort(arr2);
        int n = arr.length, m = arr2.length;
        int p1 = 0, p2 = 0;;

        // 두 배열을 오름차순 정렬을 시켰기 때문에 p1, p2 중 작은 값을 ++ 시킨다.
        while (p1 < n && p2 < m){
            if(arr[p1] < arr2[p2])p1++;
            else if (arr[p1] > arr2[p2])p2++;
            // 같은 값일 경우 저장 후 ++
            else {
                answer.add(arr[p1]);
                p1++;
                p2++;
            }
        }
        return answer;
    }
}
