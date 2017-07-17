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
    private int[] selectedNumber = new int[3];
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private boolean GAME_FLAG = true;
    public void run() {
        init();

        while(GAME_FLAG) {
            int inputNumber = input();

            judge(inputNumber);
            
            if(isGameClear()) {
                System.out.println("모든 숫자를 맞추셨습니다! 승리입니다.");
                GAME_FLAG = false;
            }
        }

        gameover();
    }

    private void gameover() {

    }

    private void judge(int inputNumber) {
    }

    private void init() {
        for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numberList.add(i);
        }

        Collections.shuffle(numberList);
        for(int i = 0; i < selectedNumber.length; i++) {
            selectedNumber[i] = numberList.get(i);
        }
    }

    private int input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("생각하고 있는 숫자 3자리를 입력해주세요.");
        int test = 0;
        
        try {
            test = Integer.parseInt(br.readLine());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return test;
    }

    public boolean isGameClear() {
        
        return true;
    }
}
