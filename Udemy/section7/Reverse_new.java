// Section 7-3, 싱글 링크드 리스트 뒤집기
// 간단하게 푸는 방법을 해설로 제시하고 있으나, 노드를 이미 있는 갯수만큼 새로 만들어줘야하는 문제가 있다.
// 이건 개선된 버전이다!

public class Reverse {
    private Node head;

    public void addToHead(int n) {
        Node newNode = new Node();
        newNode.data = n;
        newNode.next = head;
        head = newNode;
    }

    @Override
    public String toString() {
        String str = "[ ";
        for(Node n = head; n!=null; n=n.next) {
            str += n.data;
            str += " ";
        }
        str += "]";
        return str;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }
}