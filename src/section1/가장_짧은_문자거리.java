package section1;

import java.util.Scanner;

public class 가장_짧은_문자거리 {
    /*
    설명

    한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


    입력
    첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

    문자열의 길이는 100을 넘지 않는다.


    출력
    첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
   */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next1 = scanner.next();
        String next2 = scanner.next();
        int[] result = solution(next1, next2);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

    public static int[] solution (String str, String target){
        int[] answer = new int[str.length()];
        int p = 101;

        for (int i = 0; i < str.length(); i++){
            // target 문자면 0
            if (str.charAt(i) == target.charAt(0)){
                p = 0;
                answer[i] = p;
            }else {
                answer[i] = p;
            }
            p++;
        }
        p = 101;

        for (int i = str.length()-1; i >= 0; i--){
            // target 문자면 0
            if (str.charAt(i) == target.charAt(0)){
                p = 0;
                answer[i] = p;
            }else {
                answer[i] = Math.min(answer[i], p);
            }
            p++;
        }

        return answer;
    }
}
