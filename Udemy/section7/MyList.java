// Section 7-2, 싱글 링크드 리스트에서 중복 데이터 제거하기
// 이런 문제는 머릿속으로 그려보기보다는 실제로 슥슥 그려보면서 생각하는게 편한듯.
// 해설에서 풀이해주는 코드는 prev에 null, current에 head를 넣고 시작하는데 나는 조금 다르게 했다. 사실 예외 케이스를 고려해봤을 때 해설에서 풀이해주는 쪽이 맞고, 안전하다.

import java.util.HashSet;

public class MyList {
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
    
    public void removeDuplicates() {
        Node current = head;
        Node nextNode = head.next;
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(current.data);

        while(nextNode != null) {
            if(!hs.contains(nextNode.data)) {
                hs.add(nextNode.data);
                current = nextNode;
                nextNode = nextNode.next;
            } else {
                nextNode = nextNode.next;
                current.next = nextNode;
            }
        }
    }
}