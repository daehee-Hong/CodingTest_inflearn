package section2;

import java.util.*;

public class 큰_수_출력하기 {
    /*
    설명

    N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

    (첫 번째 수는 무조건 출력한다)


    입력
    첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


    출력
    자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next1 = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[next1];
        for (int i = 0; i < next1; i++) {
            arr[i] = scanner.nextInt();
        }
        List<Integer> result = solution(next1,arr);
        for (int i : result) {
            System.out.print(i  + " ");
        }

    }

    public static List<Integer> solution (int n , int[] arr){
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]){
                answer.add(arr[i]);
            }
        }

        return answer;
    }
}
