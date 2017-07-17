package Joshua.CodeSquad.Baseball;

import java.util.ArrayList;

/**
 * Created by Joshua on 2017-07-17.
 */
public class Judge {
    public boolean isGameClear(int[] inputNumber, ArrayList<Integer> selectedNumber) {
        int strike = 0, ball = 0;

        for(int i = 0; i < inputNumber.length; i++) {
            if(selectedNumber.get(i) == inputNumber[i]) {
                strike++;
            } else if(selectedNumber.contains(inputNumber[i])) {
                ball++;
            }
        }

        if(strike == 3) {
            System.out.println("3 스트라이크!");
            return true;
        } else if(strike > 0 || ball > 0) {
            System.out.println(strike + " 스트라이크 " + ball + " 볼!\n다른 숫자를 입력해보세요.");
        } else {
            System.out.println("낫싱!\n다른 숫자를 입력해보세요.");
        }

        return false;
    }
}
