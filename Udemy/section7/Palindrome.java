// Section 7-5, 싱글 링크드 리스트에서 회문 판별하는 함수 구현
// 내 방식대로 풀어보긴 했는데 출제자가 의도한 해답은 아니었다. 어쨌든 답은 나오는데 비효율적임.
// 이것도 역시 LL을 얼마나 잘 다루는지 보는 문제로, 두개의 노드를 만들어서 각각 다르게 전진시키는 것이 중요.
// 해설대로 풀은 답은 Palindrome_new.java

import java.util.Stack;

public class Palindrome {
    private Node head;

    public void addToHead(int n) {
        Node newNode = new Node();
        newNode.data = n;
        newNode.next = head;
        head = newNode;
    }

    public boolean isPalindrome() {
        Node current = head;
        Stack<Integer> st = new Stack<>();
        int index;

        while(current != null) {
            st.add(current.data);
            current = current.next;
        }

        Node prev = null;
        current = head;

        if(st.size() % 2 == 0) {
            index = st.size() / 2;
        } else {
            index = st.size() / 2 + 1;
        }

        for(int i = 0; i < index; i++) {
            if(st.elementAt(i) == st.elementAt(st.size()-i-1)) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
}