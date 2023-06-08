package section2;

import java.util.Arrays;
import java.util.Scanner;

public class 격자판_최대합 {
    /*
    설명

    5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

    Image1.jpg

    N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


    입력
    첫 줄에 자연수 N이 주어진다.(2<=N<=50)

    두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


    출력
    최대합을 출력합니다.
   */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next1 = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[next1][next1];
        for (int i = 0; i < next1; i++) {
            for (int j = 0; j < next1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int arr2 = solution(arr);
        System.out.print(arr2);
    }

    public static int solution (int[][] arr){
        int answer = Integer.MIN_VALUE;
        int sum1 = 0,sum2 = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum1=sum2=0;
            for (int j = 0; j < arr.length; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1=sum2=0;

        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][arr.length - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
}
