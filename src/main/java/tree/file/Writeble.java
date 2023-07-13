package tree.file;

import java.io.IOException;
import java.io.Serializable;

public interface Writeble {
    boolean saveing(Serializable serializable, String filepath) throws IOException;
    Object reading(String filePath) throws IOException, ClassNotFoundException;
}
