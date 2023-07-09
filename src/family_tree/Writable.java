package familyTree.src.family_tree;

import java.io.Serial;
import java.io.Serializable;
public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
