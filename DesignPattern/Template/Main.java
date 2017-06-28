package Joshua.DP.Template;

/**
 * Created by Joshua on 2017-06-28.
 */
public class Main {

    public static void main(String[] args) {
        AbstGameConnectHelper helper = new DefaultGameConnectHelper();

        helper.requestConnection("아이디/암호 등 접속 정보");
    }
}
