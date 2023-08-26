package model.save.writer;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    Object save(Serializable serializable, String path) throws IOException, ClassNotFoundException;
    Object loading(String path) throws IOException, ClassNotFoundException;
}
