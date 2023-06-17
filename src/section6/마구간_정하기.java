package section6;

import java.util.Arrays;
import java.util.Scanner;

public class 마구간_정하기 {
    /*
    설명

    N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.

    현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,

    가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.

    C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.


    입력
    첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.

    둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.


    출력
    첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
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
        int result = solution(n, m, arr);
        System.out.println(result);
    }

    public static int solution (int n, int c,int[] arr){
        /*
            입력받은 숫자가 [1,2,8,4,8], c은 3이라 하면
            각 마구간에 모든 말을 넣었을 때 최대 거리를 구한다.
            lt는 거리에서 가장 작은 값 1, rt는 배열에서 가장 큰값 - 1
            - 정렬된 값들 안에서 원하는 값이 확실히 있을 때 결정 알고리즘을 사용한다.
        */
        int answer = 1;
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[n-1];

        while (lt <= rt){
            int mid = (lt + rt) / 2;
            // check가 true면 정답이거나 정답에 가까운 수 이므로 answer에 mid 값 저장 후 rt 이동
            if (check(mid, arr) >= c){
                lt = mid + 1;
                answer = mid;
            }
            // check가 false면 정답이 아닌 수 이므로 lt를 mid 앞으로 이동
            else rt = mid - 1;
        }

        return answer;
    }
    public static int check(int mid, int[] arr){
        int ep = arr[0];// 말 배치
        int cnt = 1;    // 배치한 말의 마리수
        // 처음 말을 ep에 넣었기 때문에 1부터 시작한다.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= mid){
                ep = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}
