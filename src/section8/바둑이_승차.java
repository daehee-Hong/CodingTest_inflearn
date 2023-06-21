package section8;

import java.util.Scanner;

public class 바둑이_승차 {
    /*
    설명

    철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.

    철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.

    N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.


    입력
    첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.

    둘째 줄부터 N마리 바둑이의 무게가 주어진다.


    출력
    첫 번째 줄에 가장 무거운 무게를 출력한다.
    */
    static int n, total=0;
    static int max = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        total = scanner.nextInt();
        n = scanner.nextInt();
        //m = scanner.nextInt();


        // 리스트안에 리스트 저장 0,1,2,3,4,5 만듬
        int[] list = new int[n];
        for (int i = 0; i < n;i++){
            list[i] = scanner.nextInt();
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
        System.out.println(max);
    }


    public static int solution(int n){
        return 1;
    }

    public static void DFS(int L, int sum, int[] list){
        if (sum > total) return; // sum값이 total을 넘어가면 안됨
        if (L == n){            // 마지막 리스트 요소면 max값과 비교하여 가장 큰 값을 찾음
            if (sum > max){
                max = sum;
            }
        }else {
            DFS(L + 1, sum + list[L], list);
            DFS(L + 1, sum, list);
        }
    }
}
