package Joshua.PS;

import java.util.Scanner;

public class Oddeven {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if((input & 1) == 1) {
            System.out.println("odd");
        } else {
            System.out.println("even");
        }
    }
}