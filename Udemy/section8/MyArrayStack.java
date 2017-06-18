// Section 8-1, 배열로 스택 구현하기
// exception 처리와 스택 사이즈 늘리기를 연습할 수 있는 문제. 내 코드는 해설에서 제시한 코드와 조금 차이가 있다.
// Arrays.copyOf 사용할 수 있는 상황이면 이렇게 구현을 하고, 만약 사용할 수 없는 상황이라면 temp array를 하나 만들고 스택용 배열 사이즈를 증가시킨뒤에 System.arraycopy 사용해야될듯.

import java.util.Arrays;

public class MyArrayStack {
	private int[] data = new int[100];
	private int topIndex = -1;

    public void push(int i) {
        if(topIndex+1 == data.length) {
            data = Arrays.copyOf(data, data.length*2);
        }
        data[++topIndex] = i;
    }

    public int pop() {
        if(topIndex < 0) {
            throw new RuntimeException("empty exception");
        }
        return data[topIndex--];
    }
}