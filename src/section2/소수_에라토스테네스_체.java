package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 소수_에라토스테네스_체 {
    /*
    설명

    자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.

    만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.


    입력
    첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


    출력
    첫 줄에 소수의 개수를 출력합니다.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next1 = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[next1];

        System.out.print(solution(next1));
    }

    public static int solution (int n){
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++){
            if (arr[i] == 0){
                answer++;
                for (int j = i; j <= n; j=j+i){
                    arr[j] = 1;
                }
            }
        }

        return answer;
    }
}
