package family_tree.family_tree.model;

import java.io.ObjectInputStream;
import java.io.Serializable;

public interface Writable<G> {
    boolean save(Serializable serializable, String filePath);
    G read(String filePath);
}
