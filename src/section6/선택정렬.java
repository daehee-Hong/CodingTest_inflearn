package section6;

import section5.응급실;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 선택정렬 {
    /*
    설명

    N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

    정렬하는 방법은 선택정렬입니다.


    입력
    첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

    두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


    출력
    오름차순으로 정렬된 수열을 출력합니다.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
//        int k = scanner.nextInt();
//        int[] list = new int[k];
//        for (int l = 0; l < k; l++) {
//            list[l] = scanner.nextInt();
//        }

        int[] result = solution(n, arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution (int n, int[] arr){
        int[] answer = new int[n];
        int tmp;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }

        return arr;
    }
}
