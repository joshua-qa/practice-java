package com.joshua.Chapter01;

/**
 * Created by Joshua on 2017-04-07.
 */
public class chap1_3 {
    private static boolean palindrome(String[] str) {
        if(str[0].length() != str[1].length()) {
            return false;
        }

        char[][] alphabet = new char[2][26];

        for(int i = 0; i <= 1; i++) {
            char[] strArray = str[i].toCharArray();
            for (int j = 0; j < str[i].length(); j++) {
                int strNum = strArray[j] - 'a';
                alphabet[i][strNum]++;
            }
        }

        for(int i = 0; i < 26; i++) {
            if (alphabet[0][i] != alphabet[1][i]) {
                return false;
            }
        }

        return true;
    }

//    public static void main(String[] args) {
//        String[] str = new String[2];
//        str[0] = "abcdefg";
//        str[1] = "adefcgb";
//
//        System.out.println(palindrome(str) ? "true" : "false");
//    }
}
