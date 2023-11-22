package family_tree.family_tree.model;

import java.io.ObjectInputStream;
import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
