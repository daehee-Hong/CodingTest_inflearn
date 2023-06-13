package section5;

import java.util.*;

public class 올바른_괄호 {
    /*
    설명

    괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.

    (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.


    입력
    첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.


    출력
    첫 번째 줄에 YES, NO를 출력한다.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
//        int k = scanner.nextInt();

//        int next2 = scanner.nextInt();

//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }

        String result = solution(n);
        System.out.println(result);
    }

    public static String solution (String n){
        String answer = "NO";

        Stack<Character> stack = new Stack<>();

        char[] chars = n.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                stack.push(chars[i]);
            }else if (chars[i] == ')'){
                try{
                    stack.pop();
                }catch (EmptyStackException e){
                    return answer;
                }
            }
        }

        if (stack.isEmpty()) answer = "YES";

        return answer;
    }
}
