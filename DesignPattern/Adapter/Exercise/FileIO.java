package Joshua.DesignPattern.Adapter.Exercise;

import java.io.*;

/**
 * Created by Joshua on 2017-04-17.
 */
public interface FileIO {
    public void readFromFile(String filename) throws IOException;
    public void writeToFile(String filename) throws IOException;
    public void setValue(String key, String value);
    public String getValue(String key);
}
