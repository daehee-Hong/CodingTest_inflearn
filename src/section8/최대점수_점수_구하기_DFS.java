package section8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 최대점수_점수_구하기_DFS {
    /*
    설명

    이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.

    각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.

    제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.

    (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)


    입력
    첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.

    두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.


    출력
    첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
    */
    static int n, m;
    static int max = 0;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();


        // 리스트안에 리스트 저장 0,1,2,3,4,5 만듬
        List<Problem> list = new ArrayList<>();

        for (int i = 0; i < n;i++){
            int point = scanner.nextInt();
            int time = scanner.nextInt();
            list.add(new Problem(point, time));
        }
        DFS(0, 0, 0, list);
        System.out.println(max);
    }


    public static int solution(int n){
        return 1;
    }

    public static void DFS(int L, int timeSum, int pointSum, List<Problem> list){
        if (timeSum > m) return;    // timeSum값이 m을 넘어가면 안됨
        if (L == n){                // 마지막 리스트 요소면 max값과 비교하여 가장 큰 값을 찾음
            if (max < pointSum){
                max = pointSum;
            }
        }else {
            DFS(L + 1, timeSum + list.get(L).time, pointSum + list.get(L).point, list);
            DFS(L + 1, timeSum, pointSum, list);
        }
    }

    static class Problem {
        int point;
        int time;

        Problem(int point, int time){
            this.point = point;
            this.time = time;
        }
    }
}
