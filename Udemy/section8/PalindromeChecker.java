// Section 8-3, 스택을 사용해서 Palindrome인지 체크하기
// 홀수 case, 짝수 case를 고려해야된다는 것만 알면 쉽다.
// 해설을 보고 하나 배웠는데, 내가 구현한 방식처럼 굳이 start를 별개로 처리하지말고 두번째 for문에서 (s.length + 1) / 2 로 시작값을 잡아주면 홀짝 모두 커버 가능하다.

import java.util.Stack;

public class PalindromeChecker {
    
    public static boolean isPalindrome(String s) {
        Stack<Character> st = new Stack<Character>();

        char[] ca = s.toCharArray();
        int start = 0;

        for(int i = 0; i < ca.length/2; i++) {
            st.push(ca[i]);
        }

        if(ca.length % 2 == 1) {
            start = ca.length / 2 + 1;
        } else {
            start = ca.length / 2;
        }

        for(int i = start; i < ca.length; i++) {
            if(ca[i] == st.pop()) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}