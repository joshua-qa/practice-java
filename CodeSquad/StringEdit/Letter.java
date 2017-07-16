package Joshua.CodeSquad.StringEdit;

/**
 * Created by Joshua on 2017-07-17.
 */
public class Letter implements Comparable {
    char alphabet;
    int count;

    public Letter(char alphabet, int count) {
        this.alphabet = alphabet;
        this.count = count;
    }

    @Override
    public int compareTo(Object o) {
        int oCount = ((Letter)o).count;
        return oCount - this.count;
    }
}
