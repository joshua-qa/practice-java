package Joshua.CodeSquad.StringEdit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Joshua on 2017-07-17.
 */
public class Main {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("문장을 입력해주세요.");
        String sentence = inputSentence(br);
        StringBuilder sb = new StringBuilder();

        sb.append(reverseSentence(sentence) + "\n");

        sb.append(countAlphabet(sentence) + "\n");

        letterFrequency(sentence, sb);

        System.out.print(sb);
    }

    private void letterFrequency(String sentence, StringBuilder sb) {
        char[] lowercaseSentence = sentence.toLowerCase().toCharArray();
        int[] alphabetCountArray = new int[26];

        for(char element : lowercaseSentence) {
            if(isAlphabet(element)) {
                alphabetCountArray[element - 'a']++;
            }
        }

        ArrayList<Letter> alphabetList = new ArrayList<>();
        for(int i = 0; i < alphabetCountArray.length; i++) {
            if(alphabetCountArray[i] != 0) {
                char currentChar = (char)(i+97);
                alphabetList.add(new Letter(currentChar, alphabetCountArray[i]));
            }
        }

        Collections.sort(alphabetList);

        for(Letter l : alphabetList) {
            sb.append(l.alphabet + ": " + l.count + "\n");
        }
    }

    private String countAlphabet(String sentence) {
        char[] charArray = sentence.toCharArray();
        int alphabetCount = 0;

        for(char element : charArray) {
            if(isAlphabet(element)) {
                alphabetCount++;
            }
        }

        return "전체 수 : " + alphabetCount;
    }

    private String reverseSentence(String sentence) {
        String[] wordArray = sentence.split(" ");
        String result = "";

        for(String word : wordArray) {
            char end = word.charAt(word.length()-1);
            if(isAlphabet(end)) {
                result = word + " " + result;
            } else {
                result = word.substring(0, word.length()-1) + " " + result.trim() + end;
            }
        }
        return result;
    }

    private boolean isAlphabet(char input) {
        return ((input >= 65) && (input - 'A' < 91)) || ((input - 'a' >= 97) && (input - 'a' < 122));
    }

    private String inputSentence(BufferedReader br) throws IOException {
        while(true) {
            String input = br.readLine();
            if(input.isEmpty()) {
                System.err.println("문장을 입력하지 않았습니다. 올바른 문장을 입력해주세요.");
            } else {
                return input;
            }
        }
    }
}