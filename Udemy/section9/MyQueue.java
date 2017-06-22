// Section 9-2, 스택 두개로 큐 구현하기
// stack2에서 pop을 하고 굳이 stack1로 돌릴 필요가 없긴 한데, 가급적 한군데에만 데이터가 있는게 좋을 것 같아서 이렇게 했다.

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stack1;
    Stack<T> stack2;
    
    public MyQueue() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }
    
    public void offer(T element) {
        stack1.push(element);
    }
    
    public T poll() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        T result = stack2.pop();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }
    
    public int size() {
        return stack1.size();
    }
}