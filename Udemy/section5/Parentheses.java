// Section 5-5, N개 괄호로 만들 수 있는 모든 조합 출력하기
// 모든 괄호는 올바르게 열리고 닫혀야 함
// 올바른 조합: ()()
// 틀린 조합: )()(
// 스스로 풀었을 때 거의 근접한 줄 알았는데 문제 조건을 살짝 잘못 이해한거랑 재귀 벗어나는 조건을 잘못 설정해서 틀렸다.
// N개 괄호가 조건이므로 "("나 ")" 한개가 해당되는게 아니고 "()" 한쌍이 1개 괄호로 간주됨.
// 5-4와 더불어 조만간 다시 풀어봐야될 문제.

import java.util.List;
import java.util.ArrayList;

public class Parentheses {
    public static List<String> getPairs(int n) {
        if(n == 0) {
            return null;
        }
        return parent(n, n, "", new ArrayList<String>());
    }

    private static List<String> parent(int left, int right, String pairs, ArrayList<String> list) {
        if(left > right || left < 0 || right < 0) {
            return list;
        }
        if(left == 0 && right == 0) {
            list.add(pairs);
            return list;
        }

        parent(left-1, right, pairs + "(", list);
        parent(left, right-1, pairs + ")", list);

        return list;
    }
}