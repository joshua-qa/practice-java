// Section 4-1, 숫자로 구성된 문자열을 정수로 변환하기
// Integer.parseInt() 한줄로 해결 가능한 문제임.
// 하지만 parseInt없이 구현해보라고 한다면, 아래와 같은 형식으로 구현하면 됨.
public class StringToInt {
    public static int convert(String s) {
        char[] ca = s.toCharArray();
        int num = 0;

        for (char c:ca) {
            num *= 10;
            num += c - '0';
        }
        return num;
    }
}