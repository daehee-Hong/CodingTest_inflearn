package section6;

import java.util.*;

public class 이분검색 {
    /*
    설명

    임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면

    이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.


    입력
    첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.

    두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.


    출력
    첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
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

    public static int solution (int n, int m,int[] arr){
        int answer = 1;
        // 왼쪽을 탐색할 lt는 0번 index, rt는 마지막 인덱스를 정의
        int lt = 0, rt = n - 1;
        // lt와 rt 사이의 탐색할 변수 선언
        int mid;

        // 이분 검색은 정렬이 되어있어야한다.
        Arrays.sort(arr);

        // lt와 rt가 같으면 탐색 완료
        while (lt != rt){
            // mid 값은 lt + rt / 2 값
            mid = (lt + rt) / 2;
            // arr[mid] 값이 m이면 mid + 1 값이 순서
            if (arr[mid] == m) return mid + 1;
            // arr[mid] 값이 m 보다 크면 rt를 mid 값 뒤로 이동시킨다.
            else if (arr[mid] > m) rt = mid - 1;
            // arr[mid] 값이 m 보다 작으면 lt 값을 mid값 앞으로 이동시킨다.
            else lt = mid + 1;
        }
        answer = lt + 1;

        return answer;
    }


}
