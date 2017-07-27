package Joshua.Synap.Ladder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Game {
    public void run() {
        ArrayList<Vertex> ladderArray = new ArrayList<>();
        inputVertex(ladderArray);
        ArrayList<Vertex>[] ladder = convertVertex(ladderArray, getEdge(ladderArray));

        for(int i = 1; i < ladder.length; i++) {
            System.out.println("array " + i);
            for (Vertex v : ladder[i]) {
                System.out.println("h : (" + v.getHeight() + ") x: (" + v.getCurrentPoint() + ") y: (" + v.getTargetPoint() + ")");
            }
        }

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("사다리 정보를 입력하세요(x는 입력 완료).");

            while (true) {
                String inputString = sc.nextLine();
                if ("x".equals(inputString)) {
                    System.out.println("x");
                    break;
                }

                try {
                    int startPoint = Integer.parseInt(inputString);
                    System.out.println(getDestination(startPoint, 0, ladder));
                } catch (Exception e) {
                    System.out.println("다시 입력해주세요(x는 입력 완료).");
                    continue;
                }
            }
        }
    }

    private int getDestination(int startPoint, int height, ArrayList<Vertex>[] ladder) {
        for(Vertex v : ladder[startPoint]) {
            int vertexHeight = v.getHeight();
        }
        return 0;
    }

    private ArrayList<Vertex>[] convertVertex(ArrayList<Vertex> ladderArray, int sizeOfArray) {
        ArrayList<Vertex>[] ladder = (ArrayList<Vertex>[]) new ArrayList[sizeOfArray];
        for(int i = 1; i < sizeOfArray; i++) {
            ladder[i] = new ArrayList<>();
        }

        for(Vertex v : ladderArray) {
            int index = v.getCurrentPoint();
            ladder[index].add(v);
        }

        for(int i = 1; i < sizeOfArray; i++) {
            ladder[i].sort(Comparator.comparingInt(Vertex::getHeight));
        }

        return ladder;
    }

    private int getEdge(ArrayList<Vertex> ladderArray) {
        ArrayList<Integer> edgeList = new ArrayList<>();

        for(Vertex v : ladderArray) {
            if(!edgeList.contains(v.getCurrentPoint())) {
                edgeList.add(v.getCurrentPoint());
            }
        }

        return edgeList.size() + 1;
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
                ladderArray.add(new Vertex(height, y, x));
            } catch (Exception e) {
                System.out.println("다시 입력해주세요(x는 입력 완료).");
                continue;
            }
        }
    }
}
