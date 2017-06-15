// Section 7-5, 싱글 링크드 리스트에서 회문 판별하는 함수 구현
// 이것도 역시 LL을 얼마나 잘 다루는지 보는 문제로, 두개의 노드를 만들어서 각각 다르게 전진시키는 것이 중요.

import java.util.Stack;

public class Palindrome_new {
    private Node head;

    public void addToHead(int n) {
        Node newNode = new Node();
        newNode.data = n;
        newNode.next = head;
        head = newNode;
    }

    public boolean isPalindrome() {
        Node n1 = head;
        Node n2 = head;

        Stack<Integer> st = new Stack<Integer>();

        while(n2 != null && n2.next != null) {
            st.add(n1.data);
            n1 = n1.next;
            n2 = n2.next.next;
        }

        if(n2 != null) {
            n1 = n1.next;
        }

        while(n1 != null) {
            if(n1.data != st.pop()) {
                return false;
            } else {
                n1 = n1.next;
            }
        }
        
        return true;
    }
}