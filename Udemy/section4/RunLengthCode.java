// Section 4-4, Run Length Coding 으로 문자열 압축하기
// (글자+반복수)로 압축한다. ex) "aaabbcccc" -> "a3b2c4"
// 실전 연습 페이지에서 import 되어있는게 없어서 StringBuffer 안쓰고 처리했는데, 사용하면 더 깔끔하게 짤 수 있겠다.
// 해설 코드에서는 null 체크를 했는데, 나는 null 체크를 안해준게 실수.
// 내가 푼거랑 해설이랑 거의 방식이 비슷하긴 한데 char prev를 이용한다는게 차이점.

public class RunLengthCode {
    public static String coding(String s) {
        char[] ca = s.toCharArray();
        int current = 1;
        String result = String.valueOf(ca[0]);
        
        for(int i = 1; i < ca.length; i++) {
            if(ca[i] == ca[i-1]) {
                current++;
            } else {
                result += current;
                result += ca[i];
                current = 1;
            }
        }
        result += current;
        
		return result;
	}
}