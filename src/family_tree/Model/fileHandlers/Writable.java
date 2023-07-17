package family_tree.Model.fileHandlers;

import java.io.Serializable;

public interface Writable {

    boolean save(Serializable serializable, String filePath);

    Object read(String filePath);
}
