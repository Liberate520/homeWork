package model;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePath) throws IOException;
    Object read(String filePath) throws IOException, ClassNotFoundException;
}
