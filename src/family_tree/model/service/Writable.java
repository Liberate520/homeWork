package family_tree.model.service;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable);
    Object read(String filePath);
}
