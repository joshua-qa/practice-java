// Section 10-3, 오름차순 정렬된 배열을 BST로 변경
// 처음 풀 때는 쉽지 않은 문제라, 두세번 더 풀면서 완벽히 이해할 필요 있음.

public class BSTBuilder {
    public static Node build(int[] a) {
        return buildRec(a, 0, a.length-1);
    }

    private static Node buildRec(int[] a, int s, int e) {
        if(s > e) {
            return null;
        }

        int root = (s+e)/2;
        Node leftNode = buildRec(a, s, root-1);
        Node rightNode = buildRec(a, root+1, e);

        return new Node(a[root], leftNode, rightNode);
    }
}