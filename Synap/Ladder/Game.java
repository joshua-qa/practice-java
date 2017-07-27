package Joshua.Synap.Ladder;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public void run() {
        ArrayList<Vertex> ladderArray = new ArrayList<>();
        inputVertex(ladderArray);
        System.out.println(ladderArray.toString());
    }

    private void inputVertex(ArrayList<Vertex> ladderArray) {
        Scanner sc = new Scanner(System.in);
        System.out.println("사다리 정보를 입력하세요(x는 입력 완료).");

        while (true) {
            String[] inputString = sc.nextLine().split(" ");
            if ("x".equals(inputString[0])) {
                break;
            }

            try {
                int height = Integer.parseInt(inputString[0]);
                int x = Integer.parseInt(inputString[1]);
                int y = x + 1;
                ladderArray.add(new Vertex(height, x, y));
            } catch (Exception e) {
                System.out.println("다시 입력해주세요(x는 입력 완료).");
                continue;
            }
        }
    }
}
