package com.joshua.Chapter01;

/**
 * Created by Joshua on 2017-04-06.
 */
public class chap1_1 {
    // 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라. 다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?

    private static boolean strChecker(String str) {
        // 여기서는 문자열이 영문 소문자로만 구성되어있다는 가정으로 작성.
        boolean[] strArray = new boolean[26];

        if(str.length() > 26) {
            return false;
        }

        for(int i = 0; i < str.length(); i++) {
            int strNum = str.charAt(i) - 97;

            if(strArray[strNum]) {
                return false;
            }

            strArray[strNum] = true;
        }

        return true;
    }

//    public static void main(String[] args) {
//        String str = "abcdefghijkkmnopqrstuvwxyyzzzzzz";
//        String str2 = "abcdefg";
//
//        System.out.println(strChecker(str) ? "ok" : "fail");
//        System.out.println(strChecker(str2) ? "ok" : "fail");
//    }
}
