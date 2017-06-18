// Section 8-2, ArrayList로 스택 구현하기
// 아주 짧은 코드로 완성 할 수 있는 문제. pop에서 temp에 지울 대상을 넣고 return 해야될 줄 알았는데, 공식 문서를 보니까 remove를 하면 지운 대상이 return된다고 한다.

import java.util.ArrayList;
import java.util.List;

public class MyListStack<T> {
	
	private List<T> list;
	
	public MyListStack() {
	    list = new ArrayList<T>();
    }

    public void push(T i) {
        list.add(i);
    }

    public T pop() {
        return list.remove(list.size()-1);
    }
}