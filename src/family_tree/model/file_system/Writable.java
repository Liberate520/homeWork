package family_tree.model.file_system;

import java.io.Serializable;

public interface Writable {
    void Save(Serializable serializable, String file_path);
    Object Read(String file_path);
}
