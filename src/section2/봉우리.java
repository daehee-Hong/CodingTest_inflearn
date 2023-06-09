package section2;

import java.util.Arrays;
import java.util.Scanner;

public class 봉우리 {
    /*
    설명

    지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.

    각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.

    격자의 가장자리는 0으로 초기화 되었다고 가정한다.

    만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

    Image1.jpg


    입력
    첫 줄에 자연수 N이 주어진다.(2<=N<=50)

    두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


    출력
    봉우리의 개수를 출력하세요.
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
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if ( nx >=0 && nx<arr.length && ny >= 0 && ny < arr.length && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }

        return answer;
    }
}
