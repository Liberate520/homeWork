package family_tree.family_tree;

import java.io.Serializable;

public interface Writable {
    void save(String path, Serializable obj);
    Serializable load(String path);
}
