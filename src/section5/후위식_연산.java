package section5;

import java.util.Scanner;
import java.util.Stack;

public class 후위식_연산 {
    /*
    설명

    후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.

    만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.


    입력
    첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.

    식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.


    출력
    연산한 결과를 출력합니다.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
//
//        int[][] arr = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = scanner.nextInt();
//            }
//        }
//        int k = scanner.nextInt();
//        int[] list = new int[k];
//        for (int l = 0; l < k; l++) {
//            list[l] = scanner.nextInt();
//        }

        int result = solution(n);
        System.out.println(result);
    }

    public static int solution (String n){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        // 후위식 연산을 위해서 식을 반복
        for (char c : n.toCharArray()) {
            // 숫자면 저장
            if (Character.isDigit(c)){
                stack.push(Character.getNumericValue(c));
            }else {
                // 2개의 값을 꺼내서 연산자에 맞게 연산후 stack에 저장
                int a = stack.pop();
                int b = stack.pop();
                int result = 0;

                if (c == '+') result = b+a;
                else if (c == '-') result = b-a;
                else if (c == '*') result = b*a;
                else if (c == '/') result = b/a;
                stack.push(result);
            }
        }


        answer = stack.pop();

        return answer;
    }
}
