/**
 * Created by Joshua on 2017-06-19.
 */
public class Queens {
    final int N = 8;
    int[] cols = new int[N+1];

    public static void main(String[] args) {
        new Queens().run();
    }

    public void run() {
        queens(0);
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(cols[i+1] == j+1) {
                    System.out.print("O");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println("");
        }
    }

    private boolean queens(int level) {
        if(!promising(level)) {
            return false;
        } else if(level == N) {
            for(int i = 1; i <= N; i++) {
                System.out.println("(" + i + ", " + cols[i] + ")");
            }
            return true;
        }
        for(int i = 1; i <= N; i++) {
            cols[level+1] = i;
            if(queens(level+1)) {
                return true;
            }
        }
        return false;
    }

    private boolean promising(int level) {
        for(int i = 1; i < level; i++) {
            if(cols[i] == cols[level]) {
                return false;
            } else if(level - i == Math.abs(cols[level]-cols[i])) {
                return false;
            }
        }
        return true;
    }
}
