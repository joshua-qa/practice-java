package Joshua.DesignPattern.Adapter.Instance;

/**
 * Created by Joshua on 2017-04-17.
 */
public class Main {
    public static void main(String[] args) {
        Print p = new PrintTweet("Pop'n Music");
        p.printWeak();
        p.printStrong();
    }
}