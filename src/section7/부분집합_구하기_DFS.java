package section7;

import java.util.Scanner;

public class 부분집합_구하기_DFS {
    /*
    자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램
    을 작성하세요.
    */
    static int[] ch;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int m = scanner.nextInt();
////
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        int k = scanner.nextInt();
//        int[] list = new int[k];
//        for (int l = 0; l < k; l++) {
//            list[l] = scanner.nextInt();
//        }
        int result = solution(n);
    }

    public static int solution (int a){
        int answer = 0;
        /*
        전위순회는 부모-왼-오
        중위순회는 왼-부모-오
        후위순회는 왼-오-부모
        */
        n = a;
        ch = new int[n + 1];
        DFS(1);
        return answer;
    }

    public static void DFS(int L){
        // L 값이 n + 1이면 노드가 끝이므로 ch가 1인 값들 꺼내서 출력
        if (L == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++){
                if (ch[i] == 1) tmp+= (i + " ");
            }
            if (tmp.length() > 0) System.out.println(tmp);
        }
        else {
            ch[L] = 1;      // 왼쪽은 사용이기 때문에 1
            DFS(L + 1);  // 왼
            ch[L] = 0;      // 오른쪽은 미사용이기 때문에 0
            DFS(L + 1);  // 오
        }
    }

}
