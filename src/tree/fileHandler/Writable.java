package tree.fileHandler;

import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable, String filePath);
    Object read(String filePath);
}
