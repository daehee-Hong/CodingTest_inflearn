package section7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 합이_같은_부분집합_DFS {
    /*
    N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
    두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면
    ”NO"를 출력하는 프로그램을 작성하세요.
    둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의
    집합이 되어 합니다.
    예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이
    16으로 같은 경우가 존재하는 것을 알 수 있다.
    */
    static int n, total=0;
    static String answer = "NO";
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        //m = scanner.nextInt();


        // 리스트안에 리스트 저장 0,1,2,3,4,5 만듬
        int[] list = new int[n];
        int sum = 0;
        for (int i = 0; i < n;i++){
            list[i] = scanner.nextInt();
            total += list[i];
        }
        // 리스트안에 노드별 값 저장 1=(2,3,4), 2=(1,3), 3=(4), 4=(2,5), 5=()
//        for (int i = 0; i < m; i++) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            graph.get(a).add(b);
//        }
//        int result = solution(n);
//        System.out.println(result);
        DFS(0, 0, list);
        System.out.println(answer);
    }


    public static int solution(int n){
        return 1;
    }

    public static void DFS(int L, int sum, int[] list){
        // L 이 n 과 같으면 부분집합 생성완료
        if (flag) return;
        if (sum>total/2) return; // sum값이 total의 절반값을 넘어가면 두 부분집합의 합이 달라지므로 종료
        if (L == n){
            if ((total-sum) == sum){
                answer = "YES";
                flag = true;
            }
        }else {
            // sum + list로 0 + 1 -> 1 + 3 -> 4 + 5 -> 9 + 6 -> 15 + 7 -> 22 > total /2 return -> 15 + 10 -> 22 > total /2 return -> 16 + 10 -> 26
            DFS(L + 1, sum + list[L], list);
            DFS(L + 1, sum, list);  // 15, 15, 9, 16
        }
        /* 실행순서 [1 3 5 6 7 10]
         63번째줄 조건 걸리기 까지 탐색 5번 반복 sum = 22
         STACK (7,6,5,3,1) 에서 sum>total/2 조건 떄문에 return 후 64행
         STACK (6,5,3,1) 에서 63행
         STACK (10,6,5,3,1) 에서 sum>total/2 조건 떄문에 return 후 64행
         STACK (6,5,3,1) 에서 63행 L 인덱스 범위 넘어가서 재귀 바로 나옴 이 후 64행
         STACK (5,3,1) 에서 63행
         STACK (7,5,3,1) 에서 L 값이 n 이 아니기 때문에 한번 더 돔 63행
         STACK (10,7,5,3,1) sum>total/2 조건 떄문에 return 후 64행
         STACK (7,5,3,1)
         나머지 요소 스킵 (total-sum) == sum 조건 true이므로 answer은 "YES";
        */
    }
}
