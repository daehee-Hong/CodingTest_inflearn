package section2;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class 등수계산 {
    /*
    설명

    N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

    같은 점수가 입력될 경우 높은 등수로 동일 처리한다.

    즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.


    입력
    첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.


    출력
    입력된 순서대로 등수를 출력한다.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next1 = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[next1];
        for (int i = 0; i < next1; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] arr2 = solution(arr);
        for (int i : arr2) {
            System.out.print(i+" ");
        }
    }

    public static int[] solution (int[] arr){
        int[] answer = new int[arr.length];
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (arr[i] < arr[j]){
                    cnt++;
                }
            }
            answer[i] = cnt;
            cnt=1;
        }

        return answer;
    }

}
