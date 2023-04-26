package data;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String fileName);
    Object load(String fileName) throws IOException, ClassNotFoundException;
}
