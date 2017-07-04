// Section 10-3, 주어진 Binary Tree가 BST인지 판별하기
// 처음 풀 때는 쉽지 않은 문제라, 두세번 더 풀면서 완벽히 이해할 필요 있음.
// isBst에 재귀를 다 때려박는 코딩을 시도했는데 중요한 부분을 캐치하지 못한 상태여서 틀림. ㅠㅠ min, max값을 이용한 컨트롤이 필요.

public class TreeHandler {
    public static boolean isBst(Node root) {
        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBstRec(Node node, int min, int max) {
        if(node == null) {
            return true;
        }
        if(node.data <= min || node.data > max) {
            return false;
        }
        boolean l = isBstRec(node.left, Integer.MIN_VALUE, node.data);
        boolean r = isBstRec(node.right, node.data, Integer.MAX_VALUE);

        return l && r;
    }
}