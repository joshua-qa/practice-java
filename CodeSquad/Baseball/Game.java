package Joshua.CodeSquad.Baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Joshua on 2017-07-17.
 */
public class Game {
    private ArrayList<Integer> numberList = new ArrayList<>();
    private ArrayList<Integer> selectedNumber = new ArrayList<>();
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final int NUMBER_QUANTITY = 3;
    private boolean GAME_FLAG = true;
    public void run() {
        init();
        Judge judge = new Judge();

        while(GAME_FLAG) {
            int[] inputNumber = input();
            
            if(judge.isGameClear(inputNumber, selectedNumber)) {
                System.out.println("모든 숫자를 맞추셨습니다! 승리입니다.");
                GAME_FLAG = false;
            }
        }

        gameover();
    }

    private void gameover() {

    }


    private void init() {
        for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numberList.add(i);
        }

        Collections.shuffle(numberList);
        for(int i = 0; i < NUMBER_QUANTITY; i++) {
            selectedNumber.add(numberList.get(i));
        }
    }

    private int[] input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("생각하고 있는 숫자 3자리를 입력해주세요.");
        int[] numList = new int[3];
        
        try {
            char[] inputNum = br.readLine().toCharArray();
            for(int i = 0; i < numList.length; i++) {
                numList[i] = inputNum[i] - '0';
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return numList;
    }

}
