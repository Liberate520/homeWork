package family_tree.model.file_system;

import java.io.Serializable;

import family_tree.model.file_system.enums.StatusFileFS;

public interface Writable {
    StatusFileFS Save(Serializable serializable, String file_path);
    Object Read(String file_path);
}
