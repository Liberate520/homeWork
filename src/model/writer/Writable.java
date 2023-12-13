package model.writer;


import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read (String filePath) throws IOException;
}
