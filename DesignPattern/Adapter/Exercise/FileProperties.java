package Joshua.DesignPattern.Adapter.Exercise;

import java.io.*;
import java.util.Properties;

/**
 * Created by Joshua on 2017-04-17.
 */
public class FileProperties extends Properties implements FileIO {

    public void readFromFile(String filename) throws IOException {
        load(new FileInputStream(filename));
    }

    public void writeToFile(String filename) throws IOException {
        store(new FileOutputStream(filename), "written by FileProperties");
    }

    public void setValue(String key, String value) {
        setProperty(key, value);
    }

    public String getValue(String key) {
        return getProperty(key, "");
    }
}
