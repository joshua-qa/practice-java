// Section 10-2, Binary Tree의 Balance 체크
// 관련 자료도 많이 나와있는 문제인데 혼자 생각해서 풀기에는 조금 어려운 문제 ㅠㅠ 많이 연습해볼 필요가 있다.

public class BinaryTreeHandler {
    public static boolean isBalanced(Node root) {
        return checkDepth(root) != -1;
    }

    private static int checkDepth(Node head) {
        if(head == null) {
            return 0;
        }

        int l = checkDepth(head.left);
        if(l == -1) {
            return -1;
        }

        int r = checkDepth(head.right);
        if(r == -1) {
            return -1;
        }


        if(Math.abs(r-l) > 1) {
            return -1;
        }

        return Math.max(l,r) + 1;
    }
}