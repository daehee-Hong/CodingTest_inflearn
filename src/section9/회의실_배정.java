package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실_배정 {
    /*
    설명

    한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
    
    각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
    
    단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
    
    
    입력
    첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
    
    이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
    
    회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
    
    
    출력
    첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
   */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Time> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stToken = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(stToken.nextToken());
            int end = Integer.parseInt(stToken.nextToken());
            personList.add(new Time(start, end));
        }
        Collections.sort(personList);
        for (Time time : personList) {
            System.out.println(time.start + " " + time.end);
        }
        System.out.println(solution(personList, n));

    } // len C m


    public static int solution(List<Time> list, int n){
        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for (Time time : list) {
            if (max <= time.start){
                max = time.end;
                cnt++;
            }
        }
        return cnt;
    }

    static class Time implements Comparable<Time>{
        int start;
        int end;

        Time (int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            // 종료시간으로 오름차순 // 종료시간이 같으면 시작시간 오름차순
            if (this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }
}
