package Joshua.DesignPattern.Iterator;

/**
 * Created by Joshua on 2017-04-17.
 */
public class Song {
    private String name;
    private int level;

    public Song(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
