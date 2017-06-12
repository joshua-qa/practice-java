// Section 5-3, n비트의 모든 경우의 수를 출력
// 이 문제를 최소 단위로 쪼갰을 때, 경우의 수가 두개밖에 없다는 것을 알면 쉽다.
// 해설에서는 ArrayList<String>을 반환하는 재귀 함수를 구현하는 형식으로 해서 내 코드랑은 차이가 있으나, 접근하는 방식은 동일했다.

import java.util.ArrayList;

public class Exercise {
    public static ArrayList<String> bitCombinations(int n) {
        ArrayList<String> result = new ArrayList<String>();
        
        bit(result, new String(""), n);
        
        return result;
    }
    
    public static void bit(ArrayList<String> al, String prevString, int n) {
        if(n == 0) {
            al.add(prevString);
        } else {
            bit(al, prevString + "0", n-1);
            bit(al, prevString + "1", n-1);
        }
    }
}