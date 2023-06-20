package section7;

import java.util.*;

public class 그래프_최단거리_BFS {
    /*
    다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
    */
    static int n, m , answer = 0;
    static List<List<Integer>> graph;
    static int[] ch;

    static int[] dis;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new ArrayList<>();
        ch = new int[n + 1];
        dis = new int[n + 1];

        // 리스트안에 리스트 저장 0,1,2,3,4,5 만듬
        for (int i = 0; i <= n;i++){
            graph.add(new ArrayList<>());
        }
        // 리스트안에 노드별 값 저장
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
        BFS_(1);
        System.out.println(graph);
        System.out.println(Arrays.toString(dis));
        int num = 1;

        for (int i = 1; i < dis.length; i++){
            if (num != 1){
                System.out.print(num + " : " + dis[i]);
                System.out.println();
            }
            num++;
        }
        return 1;
    }
    // 레벨별 풀이
    /*
            1       -   0
          3   4     -   1
            5   6   -   2
              2     -   3
    */
    public static void BFS(int v){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            // 레벨별 탐색
            for (int i = 0; i < len; i++) {
                // 현재 노드 꺼내기
                int cur = Q.poll();
                // 현재 노드가 몇 레벨만에 접근했는지 저장
                dis[cur] = L;
                // 현재 노드에 연결된 노드 탐색해서 체크안된 곳있으면 체크하고 Q에 저장
                // 예) 현재 1번 노드 -> 3,4 번 탐색
                for (int nv : graph.get(cur)){
                    if (ch[nv] == 0){
                        ch[nv] = 1;
                        Q.offer(nv);
                    }
                }
            }
            L++;
        }
    }
    // 강의 풀이
    public static void BFS_(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        dis[v] = 0;
        while (!Q.isEmpty()){
            int cv = Q.poll();
            // cv 현재 -> nv 다음
            // 현재 노드를 돌려서 다음노드들을 가져옴
            for (int nv : graph.get(cv)) {
                if (ch[nv] == 0){
                    ch[nv] = 1;
                    Q.offer(nv);
                    dis[nv] = dis[cv] + 1; // 다음 노드의 레벨 값이 이전 노드의 레벨 값의 + 1
                }
            }
        }
    }
}
