package section2;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class 가위_바위_보 {
    /*
    설명

    A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.

    가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.

    예를 들어 N=5이면

    Image1.jpg

    두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


    입력
    첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.

    두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.

    세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


    출력
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next1 = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[next1];
        int[] arr2 = new int[next1];
        for (int i = 0; i < next1; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < next1; i++) {
            arr2[i] = scanner.nextInt();
        }
        List<String> result = solution(next1,arr,arr2);
        for (String s : result) {
            System.out.println(s);
        }

    }

    public static List<String> solution (int n , int[] arrA, int[] arrB){
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arrA[i] == 1){
                if (arrB[i] == 1)answer.add("D");
                if (arrB[i] == 2)answer.add("B");
                if (arrB[i] == 3)answer.add("A");
            }else if (arrA[i] == 2){
                if (arrB[i] == 1)answer.add("A");
                if (arrB[i] == 2)answer.add("D");
                if (arrB[i] == 3)answer.add("B");
            }else if (arrA[i] == 3){
                if (arrB[i] == 1)answer.add("B");
                if (arrB[i] == 2)answer.add("A");
                if (arrB[i] == 3)answer.add("D");
            }
        }

        return answer;
    }
}
