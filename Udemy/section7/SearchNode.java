// Section 7-4, 싱글 링크드 리스트에서 뒤에서 K번째 원소를 반환하는 함수 구현
// 책에도 잘 나와있는 문제다. 노드를 두개 만들어서 하나 k만큼 전진시키고,
// 두개를 동시에 끝까지 전진시켜서 앞에 있는 노드가 끝에 닿았을 때 뒤에 있는 애를 리턴해주면 된다.

public class SearchNode {
    private Node head;

    public void addToHead(int n) {
        Node newNode = new Node();
        newNode.data = n;
        newNode.next = head;
        head = newNode;
    }

    public Node kthToLast(int k) {
        if(k < 0) {
            return null;
        }
        Node current = head;
        Node kNode = head;
        for(int i = 0; i < k; i++) {
            if(kNode == null) {
                return null;
            }
            kNode = kNode.next;
        }
        
        while(kNode.next != null) {
            current = current.next;
            kNode = kNode.next;
        }
        
        return current;
    }
}