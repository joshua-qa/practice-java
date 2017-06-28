package Joshua.DP.Strategy;

/**
 * Created by Joshua on 2017-06-28.
 */
public class AObj {

    Ainterface ainterface;

    public AObj() {
        ainterface = new AinterfaceImpl();
    }

    public void funcAA() {
        ainterface.funcA();
        ainterface.funcA();
    }
}
