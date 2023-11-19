package family_tree.model.file_system;

import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable, String file_path);
    Object read(String file_path);
}
