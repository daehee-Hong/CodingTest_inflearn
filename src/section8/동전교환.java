package section8;

import java.util.*;
import java.util.stream.Collectors;

public class 동전교환 {
    /*
    설명

    다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?

    각 단위의 동전은 무한정 쓸 수 있다.


    입력
    첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,

    그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.


    출력
    첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
    */
    static int n, m;
    static int answer = 999;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        Integer[] coinList = new Integer[n];
        for (int i = 0; i < n; i++) {
            coinList[i] = scanner.nextInt();
            q.offer(coinList[i]);
        }
        // 내림차순으로 정렬하여 큰값 먼저 값을 구하도록 처리
        Arrays.sort(coinList, Collections.reverseOrder());
        q = q.stream().sorted(Collections.reverseOrder()).collect(Collectors.toCollection(LinkedList::new));

        m = scanner.nextInt();

        //DFS(0, 0, coinList);
        BFS(coinList);
        System.out.println(answer);

    }


    public static int solution(int n){
        return 1;
    }

    public static void DFS(int L, int sum, Integer[] coinList){
        if (sum > m || answer <= L) return;
        if (sum == m){
            answer = Math.min(answer, L);
        }else {
            for (int i = 0; i < coinList.length; i++) {
                DFS(L + 1, sum + coinList[i], coinList);
            }
        }
    }

    public static int BFS(Integer[] coinList) {
        answer = 1;
        while (!q.isEmpty()){
            answer++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                if (cur == m) return answer + 1;
                for (Integer x : coinList) {
                    int sum = cur + x;
                    if (sum == m) return answer + 1;
                    if (sum < m) q.offer(sum);
                }
            }
        }
        return answer;
    }

}
