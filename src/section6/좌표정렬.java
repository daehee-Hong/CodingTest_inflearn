package section6;

import java.util.*;

public class 좌표정렬 {
    /*
    설명

    N개의 평면상의 좌표(x, y)가` 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.

    정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.


    입력
    첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.

    두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.


    출력
    N개의 좌표를 정렬하여 출력하세요.`
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int s = scanner.nextInt();
        int n = scanner.nextInt();
//
//        int[] arr = new int[n];
        List<Xy> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(new Xy(scanner.nextInt(), scanner.nextInt()));
        }
//        int k = scanner.nextInt();
//        int[] list = new int[k];
//        for (int l = 0; l < k; l++) {
//            list[l] = scanner.nextInt();
//        }

        List<Xy> result = solution(n, arr);
        for (Xy i : result) {
            System.out.print(i.getX() + " " + i.getY());
            System.out.println();
        }

    }

    public static List<Xy> solution (int n, List<Xy> arr){
        int[] answer = new int[2];

        // collections.sort 사용시 Comparable가 구현되어있으면 구현된것으로 정렬됨
        Collections.sort(arr);

        return arr;
    }

    static class Xy implements Comparable<Xy>{
        private int x;
        private int y;

        Xy (int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Xy o) {
            // 오름차순은 음수값이 리턴되도록 설정 this가 왼쪽에 있으면 오름차순
            // x값이 같으면 y값을 정렬하도록 설정
            if (this.x == o.getX()) return this.y - o.getY();
            return this.x - o.getX();
        }
    }
}
