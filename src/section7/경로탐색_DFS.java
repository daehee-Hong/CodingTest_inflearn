package section7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 경로탐색_DFS {
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
    static int[][] graph;
    static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new int[n+1][n+1];
        ch = new int[n+1];

        for (int i = 0; i < m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }
        int result = solution(n);
        System.out.println(result);
    }


    public static int solution(int n){
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
        return 1;
    }

    public static int DFS(int v){
        if (v == n) answer++; // v (현재노드)가 m(목표노드)면 경로하나 탐색한것이므로 + 1
        else {
            // n만큼 (노드만큼) 반복한다.
            for (int i=1; i<=n; i++){
                // 그래프에서 v행을 탐색해서 1이고 방문한 길이 아니면 체크 후 방문끝나면 체크 아웃
                if (graph[v][i] == 1 && ch[i] == 0){
                    // 체크
                    ch[i] = 1;
                    DFS(i);
                    // 방문끝났으면 체크 풀기
                    ch[i] = 0;
                }
            }
        }
        return answer;
    }

}
