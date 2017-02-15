package Joshua.DS.BS;

import java.util.Scanner;

/**
 * Created by Joshua on 2017-02-15.
 */
public class ArrayBinarySearch {
    public static int[] searchArray = new int[100];

    public static int binarySearch(int searchNum) {
        int min = 0;
        int max = searchArray.length;
        int position = (min + max) / 2;
        int searchCount = 0;

        while (searchArray[position] != searchNum) {
            searchCount++;
            if (searchArray[position] == searchNum) {
                break;
            } else if (searchArray[position] < searchNum) {
                min = position + 1;
                position = (min + max) / 2;
                System.out.println("current min : " + min + "\ncurrent max : " + max + "\ncurrent position : " + position);
            } else if (searchArray[position] > searchNum) {
                max = position - 1;
                position = (min + max) / 2;
                System.out.println("current min : " + min + "\ncurrent max : " + max + "\ncurrent position : " + position);
            }
        }

        System.out.println("Search Count : " + searchCount);
        return position;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputNum = scan.nextInt();

        for (int i = 0; i < 100; i++) {
            searchArray[i] = i;
        }

        System.out.println("Result : searchArray[" + binarySearch(inputNum) + "]");
    }
}
