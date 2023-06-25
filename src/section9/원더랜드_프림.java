package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 원더랜드_프림 {
    /*
    설명

    원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.

    원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.

    아래의 그림은 그 한 예를 설명하는 그림이다.

    Image1.jpg

    위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.


    입력
    첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.

    다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.

    이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.


    출력
    모든 도시를 연결하면서 드는 최소비용을 출려한다.

    최소스패닝트리 : 크루스칼

    Disjoint-Set : Union&Find (트리 구조 파악 및 연결시 사용하는 알고리즘)

   */
    static int[] unf;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>(); // graph 연결리스트로 작성

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        int[] ch = new int[n + 1];

        for (int i = 0; i < m; i ++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            // 서로 연결된 간선일 경우 a -> b, b -> a 둘다 만들어줘야함
            graph.get(a).add(new Edge(b, cost));
            graph.get(b).add(new Edge(a, cost));
        }
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>(); // 정렬 설정안하면 기본 오름차순 정렬
        pQ.offer(new Edge(1, 0)); // 초기값

        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll();   // 현재 q 값 꺼내서 연결된 노드값을 변수 저장
            int vex = tmp.vex;
            if (ch[vex] == 0){      // ch 배열에서 해당 정점이 이미 선택된 정점인지 확인
                ch[vex] = 1;        // ch 이미 연결된 정점은 1로 변경
                for (Edge edge : graph.get(vex)) {
                    if (ch[edge.vex] == 0) pQ.offer(edge); // 연결됐던 정점이 아니면 해당 정점에 연결된 정점들 pQ에 저장
                }
                answer += tmp.cost; // 경로값 answer에 누적
            }
        }

        System.out.println(answer);
    }

    public static class Edge implements Comparable<Edge>{
        int vex;
        int cost;

        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){ // 최소시간 기준 오름차순 정렬 필요
            return this.cost - o.cost;
        }
    }
}
