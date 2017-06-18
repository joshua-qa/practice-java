// Section 8-4, 스택을 구현하기
// 최소값을 반환해주는 min 함수를 O(1)에 구현해야되기 때문에 처리가 조금 복잡하다.
// 크게 어렵진 않지만, 예외 조건을 잘 생각해서 짜야된다.

import java.util.Stack;

public class MyStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
	
	public MyStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int newVal) {
	    stack.push(newVal);
	    if(minStack.empty() || minStack.peek() >= newVal) {
	        minStack.push(newVal);
	    }
	}
	
	public int pop() {
	    if(!minStack.empty() && minStack.peek() == stack.peek()) {
	        minStack.pop();
	    }
		return stack.pop();
	}
	
	public int min() {
	    if(minStack.empty()) {
	        return -1;
	    }
	    return minStack.peek();
	}
}