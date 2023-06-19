package section7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree말단_노드까지_가장짧은경로_BFS {
    /*
    아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를
    구하는 프로그램을 작성하세요.
    각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를
    길이로 하겠습니다.

            1
         2     3
       4   5

     위 트리에서 말단노드까지의 간선이 가장작은건 1-3 쪽이므로 1
    */
    static Node root;
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
        System.out.println(result);
    }


    public static int solution(int n){
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
//        root.rt.lt = new Node(6);
//        root.rt.rt = new Node(7);
        System.out.println(BFS(root));
        return 1;
    }

    public static int BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            // 레벨에 있는 노드 길이 만큼 반복
            for (int i = 0; i < len; i++) {
                Node current = Q.poll();    // 현재 노드 확인
                if (current.lt==null && current.rt==null) return L; // 말단노드를 발견히면 L 레벨 반환
                if (current.lt!=null) Q.offer(current.lt);  // 왼쪽 자식이 있으면 q에 저장
                if (current.rt!=null) Q.offer(current.rt);  // 오른쪽 자식이 있으면 q에 저장
            }
            L++;
        }
        return L;
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
