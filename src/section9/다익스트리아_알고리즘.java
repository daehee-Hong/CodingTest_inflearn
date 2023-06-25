package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다익스트리아_알고리즘 {
    /*
        아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로
    그램을 작성하세요. (경로가 없으면 Impossible를 출력한다)
    2 5
    1 2 5
    12
    5
    4
    5
    2
    3 4 6
    5
    5
    ▣ 입력설명
    첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
    결정보와 거리비용이 주어진다.
    ▣ 출력설명
    1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.
   */
    static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        // dis 배열에 최대값 추가
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            int value = Integer.parseInt(st2.nextToken());
            graph.get(x).add(new Edge(y, value));
        }

        solution(graph, 1);

        for (int i = 2; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            }else {
                System.out.println(i + " : " + dis[i]);

            }
        }
    }


    public static void solution(List<List<Edge>> graph, int start) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        // 초기값 설정
        pQ.offer(new Edge(start, 0));
        dis[start] = 0;
        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int cur = tmp.vex;
            int curCost = tmp.cost;
            if (curCost > dis[cur]) continue;
            for (Edge ob : graph.get(cur)){
                // 간선간 이동 가중치를 더해서 기존과 비교후 작은 값을 dis에 저장
                if (dis[ob.vex] > curCost + ob.cost){
                    dis[ob.vex] = curCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, curCost + ob.cost)); // 다음 노드 파악시 이전 코스트 값을 더한 값을 가져가게한다.
                }
            }
        }
    }
    public static class Edge implements Comparable<Edge>{
        int vex;    // 정점
        int cost;   // 비용

        Edge (int vex, int cost){
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
