package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최대_수입_스케쥴 {
    /*
    설명

    현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.

    각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.

    단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.


    입력
    첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.


    출력
    첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
   */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        List<Time> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stToken = new StringTokenizer(bf.readLine());
            int money = Integer.parseInt(stToken.nextToken());
            int day = Integer.parseInt(stToken.nextToken());
            if (max < day) max = day;
            personList.add(new Time(money, day));
        }
        Collections.sort(personList);

//        for (Time time : personList) {
//            System.out.println(time.money + " " + time.day);
//        }
//        for (Time time : personList) {
//            System.out.println(time.time + " " + time.state);
//        }
       System.out.println(solution(personList, max));

    } // len C m


    public static int solution(List<Time> list, int max){
        int min = Integer.MAX_VALUE;
        int sum = 0;

        PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
        //Q.offer(time.day);
        int j = 0; // day 값이 i 보다 작으면 break기 때문에 j값을 보존할 수 있어서 j를 밖에서 선언
        for (int i = max; i >= 1; i--){
            for (; j < list.size(); j++) {
                 if (list.get(j).day < i) break; // break로 j값이 2에서 멈추고 q.poll 4에서 멈추고 q.poll 6에서 끝남
                 Q.offer(list.get(j).money);
            }
            if (!Q.isEmpty()) sum += Q.poll();
        }

        return sum;
    }

    static class Time implements Comparable<Time>{
        int money;
        int day;

        Time (int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Time o) {
            // 종료시간으로 오름차순 // 종료시간이 같으면 시작,종료 상태 오름차순 e가 먼저 나오도록
            if (this.day == o.day) return o.money - this.money;
            else return o.day - this.day;
        }
    }
}
