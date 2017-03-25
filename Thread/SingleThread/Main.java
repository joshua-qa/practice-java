package Joshua.Thread.SingleThread;

/**
 * Created by Joshua on 2017-03-25.
 */
public class Main extends Thread {
    public void run() {
        System.out.println("test start");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("test end");
    }

    public static void main(String[] args) {
        Thread t = new Main();
        t.start();
    }
}
