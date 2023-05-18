package writeAndread;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void write(Serializable serializable, String filePath) throws IOException;
    Object read(String filePath) throws IOException, ClassNotFoundException;
}
