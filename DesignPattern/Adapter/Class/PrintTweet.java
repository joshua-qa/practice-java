package Joshua.DesignPattern.Adapter.Class;

/**
 * Created by Joshua on 2017-04-17.
 */
public class PrintTweet extends Tweet implements Print {
    public PrintTweet(String tweetString) {
        super(tweetString);
    }

    public void printWeak() {
        showWithParen();
    }

    public void printStrong() {
        showWithAster();
    }
}
