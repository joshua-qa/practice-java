import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Manacher {
    public static void main(String[] args) {
        new Manacher().run();
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            System.out.println(manacher(input));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private String manacher(String input) {
        char[] S = input.toCharArray();
        int N = S.length, r = 0, p = 0;
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            if (i <= r) {
                A[i] = Math.min(2 * p - i, r - i);
            }
            while (i - A[i] - 1 >= 0 && i + A[i] + 1 < N && S[i - A[i] - 1] == S[i + A[i] + 1]) {
                A[i]++;
            }
            if (r < i + A[i]) {
                r = i + A[i];
                p = i;
            }
        }

        return Arrays.toString(A);
    }
}
