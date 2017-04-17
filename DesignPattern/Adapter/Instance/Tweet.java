package Joshua.DesignPattern.Adapter.Instance;

/**
 * Created by Joshua on 2017-04-17.
 */
public class Tweet {
    private String tweetString;

    public Tweet(String tweetString) {
        this.tweetString = tweetString;
    }

    public void showWithParen() {
        System.out.println("(" + tweetString +")");
    }

    public void showWithAster() {
        System.out.println("*" + tweetString + "*");
    }
}
