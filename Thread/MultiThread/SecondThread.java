package Joshua.Thread.MultiThread;

/**
 * Created by Joshua on 2017-03-25.
 */
public class SecondThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " : Thread2");
        }
    }
}
