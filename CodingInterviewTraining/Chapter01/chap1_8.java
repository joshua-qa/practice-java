package com.joshua.Chapter01;

/**
 * Created by Joshua on 2017-05-18.
 * 한 단어가 다른 단어에 포함된 문자열인지 판별하는 메서드 작성
 */
public class chap1_8 {

    public static boolean isSubstring(String input, String origin) {
        String doubleOrigin = origin + origin;

        if(doubleOrigin.contains(input)) {
            return true;
        } else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        String origin = "waterbottle";
//        String input = "erbottlewat";
//
//        System.out.print(isSubstring(origin, input));
//    }
}
