package Joshua.algorithm.Fibonacci;

import java.util.Scanner;

/**
 * Created by Joshua on 2017-03-06.
 */
public class Fibonacci {
    private static long[] fiboArray = new long[91];

    public static long Fibo(int index) {
        if(index == 1 || index == 2) {
            return 1;
        } else if(fiboArray[index] != 0) {
            return fiboArray[index];
        } else {
            fiboArray[index] = Fibo(index-2) + Fibo(index-1);
        }

        return fiboArray[index];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputNum = scan.nextInt();

        System.out.println(Fibo(inputNum));
    }
}