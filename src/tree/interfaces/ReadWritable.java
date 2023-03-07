package tree.interfaces;

import java.io.IOException;
import java.io.Serializable;

public interface ReadWritable {
    void write(Serializable obj) throws IOException;
    Object read() throws IOException, ClassNotFoundException;
}
