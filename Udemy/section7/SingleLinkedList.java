// Section 7-1, 싱글 링크드 리스트에 addToHead, removeFirst 구현하기
// 간단한 노드 추가, 삭제다.
// 평소 습관대로 Node temp를 만들었는데 사실 그거 없이 head = head.next로 구현해도 되는 상황이긴 하다.

import java.lang.RuntimeException;

public class SingleLinkedList {
    private Node head;
    
    public void addToHead(int n) {
        Node newNode = new Node();
        
        newNode.data = n;
        newNode.next = head;
        head = newNode;
    }
    
    public void removeFirst() throws RuntimeException {
        if(head == null) {
            throw new RuntimeException();
        }
        Node temp = head;
        head = temp.next;
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
}