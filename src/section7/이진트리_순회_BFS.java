package section7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 이진트리_순회_BFS {
    /*
    아래 그림과 같은 이진트리를 레벨탐색 연습하세요.
    */
    static int[] ch;
    static int n;
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

    public static int solution (int a){
        int answer = 0;
        /*
        넓이우선탐색 : 레벨탐색
        노드 레벨 순서에 맞게 탐색한다.
        Queue 사용
        */
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
        return answer;
    }

    public static void BFS(Node tree){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(tree);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L + " : ");
            // L (레벨)에 있는 모든 원소 반복
            for (int i = 0; i < len; i++){
                Node current = Q.poll();
                System.out.print(current.data + " ");
                // 왼쪽이 있으면 q에 저장
                if (current.lt != null) Q.offer(current.lt);
                // 오른쪽이 있으면 q에 저장
                if (current.rt != null) Q.offer(current.rt);
            }
            L++;
            System.out.println();
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
