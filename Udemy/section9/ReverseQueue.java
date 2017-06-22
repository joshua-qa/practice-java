// Section 9-1, 스택 이용해서 큐 뒤집기
// 사용법만 알면 쉽다. while문은 사실 isEmpty로 조건 넣어도 상관없음.

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue<T> {
    public Queue reverse(Queue<T> q){
        Stack<T> st = new Stack<T>();
        while(q.peek() != null) {
            st.push(q.poll());
        }
        
        while(st.size() != 0) {
            q.offer(st.pop());
        }
        
        return q;
    }
}