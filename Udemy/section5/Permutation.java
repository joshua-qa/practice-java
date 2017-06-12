// Section 5-4, 순열 구하기
// 예제: "123" -> ["123", "132", "213", "231", "312", "321"]
// 재귀를 이해하기에 좋은 문제같다. 원리는 이해했는데, 추후에 해설의 도움 없이 다시 풀어봐야될 문제.

import java.util.List;
import java.util.ArrayList;

public class Permutation {
	public static List<String> getPermutations(String s) {
		if(s == null) {
            return null;
        }
        return permRec(s, new boolean[s.length()], "", new ArrayList<String>());
	}

    private static List<String> permRec(String s, boolean[] pick, String perm, ArrayList<String> result) {
        if(s.length() == perm.length()) {
            result.add(perm);
        }

        for(int i = 0; i < s.length(); i++) {
            if(pick[i]) {
                continue;
            }

            pick[i] = true;
            permRec(s, pick, perm + s.charAt(i), result);
            pick[i] = false;
        }

        return result;
    }
}