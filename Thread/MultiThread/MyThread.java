package Joshua.Thread.MultiThread;

/**
 * Created by Joshua on 2017-03-25.
 */
public class MyThread implements Runnable {
    int seq;

    public MyThread(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + seq + " : " + i);
        }
    }
}
