package tree;

import java.io.Serializable;

public interface Writeable {
    boolean writeToFile (Serializable serializable, String filePath);
        Object readFromFile (String filePath);
}
