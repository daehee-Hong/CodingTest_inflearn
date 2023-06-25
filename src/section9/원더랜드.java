package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 원더랜드 {
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

        List<Edge> list = new ArrayList<>();

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;

        for (int i = 1; i <=m; i ++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            int v1 = Integer.parseInt(st2.nextToken());
            int v2 = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            list.add(new Edge(v1, v2, cost));
        }
        int answer = 0;
        Collections.sort(list);

        for (Edge ob : list) {
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);
            if (fv1 != fv2) {
                answer += ob.cost;
                // 서로 다르기 때문에 같은 집합으로 만들어줌
                Union(ob.v1, ob.v2);
            }
        }

        System.out.println(answer);
    }

    public static void Union(int a, int b){
        int fa = Find(a); // a의 부모노드 찾기
        int fb = Find(b); // b의 부모노드 찾기
        if (fa != fb) unf[fa] = fb; // 같지 않으면 변경
    }

    public static int Find(int v){
        if (v == unf[v]) return v;
        else return Find(unf[v]);
    }

    public static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){ // 최소시간 기준 오름차순 정렬 필요
            return this.cost - o.cost;
        }
    }
}
