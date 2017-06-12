// Section 4-3, 두 문자열이 애너그램(anagram)관계인지 판별하기
// 예전에 풀었을 때는 int[256] 가지고 처리했지만, 여기서는 아스키 범위를 넘어서는 문자열도 처리할 수 있도록 구현
// HashMap을 이용하여 O(N)으로 구한다.

import java.util.HashMap;

public class Anagram {
    public static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for(char c:s1.toCharArray()) {
            if(hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
        }
        
        for(char c:s2.toCharArray()) {
            if(!hm.containsKey(c)) {
                return false;
            }
            if(hm.get(c) == 0) {
                return false;
            }
            hm.put(c, hm.get(c) -1);
        }
        
        return true;
    }
}