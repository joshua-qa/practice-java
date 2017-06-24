// Section 10-1, Binary Tree 최대값 구하기
// Binary Search Tree인 경우에는 오른쪽만 탐색해서 찾으면 되는데 이 경우에는 모든 노드를 찾아서 최대값을 구해야한다.
// Recursion으로 해결 가능.

public class BinaryTreeHandler {
    static int max = 0;
    public static int getMax(Node head) {
        if(head == null) {
            return 0;
        }
        
        Node curr = head;
        
        if(max < curr.data) {
            max = curr.data;
        }
        
        getMax(curr.left);
        getMax(curr.right);
        
        return max;
    }
}