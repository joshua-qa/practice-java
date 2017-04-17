package Joshua.DesignPattern.Adapter.Instance;

/**
 * Created by Joshua on 2017-04-17.
 */
public class PrintTweet extends Print {
    private Tweet tweet;
    public PrintTweet(String tweetString) {
        this.tweet = new Tweet(tweetString);
    }

    public void printWeak() {
        tweet.showWithParen();
    }

    public void printStrong() {
        tweet.showWithAster();
    }
}
