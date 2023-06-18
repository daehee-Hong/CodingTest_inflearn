package section7;

import java.util.Arrays;
import java.util.Scanner;

public class 이진트리_순회_깊이우선탐색_DFS {
    /*
    아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요

    전위순회 출력 : 1 2 4 5 3 6 7
    중위순회 출력 : 4 2 5 1 6 3 7
    후위순회 출력 : 4 5 2 6 7 3 1
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int m = scanner.nextInt();
////
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        int k = scanner.nextInt();
//        int[] list = new int[k];
//        for (int l = 0; l < k; l++) {
//            list[l] = scanner.nextInt();
//        }
        int result = solution(n);
    }

    public static int solution (int n){
        int answer = 0;
        /*
        전위순회는 부모-왼-오
        중위순회는 왼-부모-오
        후위순회는 왼-오-부모
        */
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
        return answer;
    }

    public static void DFS(Node root){
        // root가 null 이면 말단 노드 이므로 종료
        if (root == null) return;
        else {
            // System.out.print(root.data + " "); 출력이 lt rt 앞에 있으면 전위순회
            DFS(root.lt); // 왼쪽을 끝까지 탐색
            System.out.print(root.data + " "); // 출력이 lt rt 중간에 있으면 중위순회
            DFS(root.rt); // 그 다음 오른쪽 탐색
            // System.out.print(root.data + " "); 출력이 lt rt 뒤에 있으면 후위순회
        }
    }

    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

}
