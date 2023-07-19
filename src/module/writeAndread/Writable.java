package module.writeAndread;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void write(Serializable serializable) throws IOException;
    Object read(String file) throws IOException, ClassNotFoundException;
}
