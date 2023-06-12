package section4;

import java.util.HashMap;
import java.util.Scanner;

public class 모든_아나그램_찾기 {
    /*
    설명

    S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

    아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.


    입력
    첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.

    S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.


    출력
    S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
//        int next2 = scanner.nextInt();

//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }

        int result = solution(s, t);
        System.out.println(result);
    }

    public static int solution (String n, String k){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int lt = 0;
        int cnt = 0;

        char[] chars = n.toCharArray();
        char[] chars2 = k.toCharArray();

        for (int i = 0; i < k.length(); i++) {
            map2.put(chars2[i], map2.getOrDefault(chars2[i], 0) + 1);
        }

        for (int rt = 0; rt < n.length(); rt++) {
            cnt++;
            map.put(chars[rt], map.getOrDefault(chars[rt], 0) + 1);

            while(cnt >= k.length()){

                if (map.equals(map2)){
                    answer++;
                }
                if (map.get(chars[lt]) > 1){
                    map.put(chars[lt], map.get(chars[lt]) - 1);
                }else {
                    // 중복값이 없으면 삭제한다.
                    map.remove(chars[lt]);
                }
                lt++;
                cnt--;
            }
        }

        return answer;
    }
}

