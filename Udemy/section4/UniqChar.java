// Section 4-2, 주어진 문자열에서 모든 문자가 유일한지 판단하기
// Test Case에 대문자가 섞여있는 것 같아서 toUpperCase 해주고 계산했음
// 알파벳만 들어간다고 가정하고 26으로 짠거라 실제로는 256으로 다 커버 가능하게 해야함
// (코딩 인터뷰 완전분석에서 비슷한 문제 풀어봤었음)
// 강의 해설은 HashSet 기준으로. (이쪽이 좀 더 안전함)

import java.util.HashSet;

public class UniqChar {
    public static boolean isUniqChar(String s) {
        // char[] ca = s.toUpperCase().toCharArray();
        // int[] cArray = new int[26];
        
        // for (char c:ca) {
        //     cArray[c - 'A']++;
        //     if(cArray[c - 'A'] > 1) {
        //         return false;
        //     }
        // }
        
        Hash<Character> set = new HashSet<Character>();

        for(char c:s.toCharArray()) {
            if(set.contains(c)) {
                return false;
            }
            set.add(c);
        }

		return true;
	}
}