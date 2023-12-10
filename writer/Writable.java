package family_tree.writer;

import java.io.ObjectInputStream;
import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
