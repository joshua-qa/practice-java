package Joshua.Thread.MultiThread;

/**
 * Created by Joshua on 2017-03-25.
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(1));
        Thread t2 = new Thread(new MyThread(2));
        //Thread t2 = new Thread(new SecondThread());

        t1.start();
        t2.start();
    }
}
