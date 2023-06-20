package section7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 경로탐색_인접리스트 {
    /*
    방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프
    로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
    1 2 3 4 5
    1 2 5
    1 3 4 2 5
    1 3 4 5
    1 4 2 5
    1 4 5
    총 6 가지입니다.
    */
    static int n, m , answer = 0;
    static List<List<Integer>> graph;
    static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new ArrayList<>();
        ch = new int[n+1];

        // 리스트안에 리스트 저장 0,1,2,3,4,5 만듬
        for (int i = 0; i < n;i++){
            graph.add(new ArrayList<Integer>());
        }
        // 리스트안에 노드별 값 저장 1=(2,3,4), 2=(1,3), 3=(4), 4=(2,5), 5=()
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }
        int result = solution(n);
        System.out.println(result);
    }


    public static int solution(int n){
        ch[1] = 1;
        DFS(1);
        System.out.println(graph);
        System.out.println(answer);
        return 1;
    }

    public static int DFS(int v){
        if (v == n) answer++; // v (현재노드)가 m(목표노드)면 경로하나 탐색한것이므로 + 1
        else {
            // v 번째 List 탐색
            for (int nv : graph.get(v)){
                if (ch[nv] == 0){
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
        return answer;
    }
}
