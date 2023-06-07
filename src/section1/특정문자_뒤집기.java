package section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 특정문자_뒤집기 {
    /*
    설명

    영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,

    특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


    입력
    첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


    출력
    첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        String result = solution(next);
        System.out.println(result);
    }

    public static String solution (String str){
        String answer = "";

        char[] chars = str.toCharArray();
        int lt = 0, gt = chars.length -1;

        while (lt < gt){
            if (!Character.isAlphabetic(chars[lt])) lt++;
             else if (!Character.isAlphabetic(chars[gt])) gt--;
             else {
                char tmp = chars[lt];
                chars[lt] = chars[gt];
                chars[gt] = tmp;
                lt++;
                gt--;
            }
        }

        return String.valueOf(chars);
    }
}
