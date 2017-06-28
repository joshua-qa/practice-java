package Joshua.DP.Strategy;

/**
 * Created by Joshua on 2017-06-28.
 */
public class Main {

    public static void main(String[] args) {
        Ainterface ainterface = new AinterfaceImpl();

        ainterface.funcA();

        AObj aobj = new AObj();
        aobj.funcAA();

        GameCharacter character = new GameCharacter();

        character.attack();

        character.setWeapon(new Knife());
        character.attack();

        character.setWeapon(new Sword());
        character.attack();
    }
}
