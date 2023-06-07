package tree.saveLoad;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable serializable, String filePath);
    Object load(String filePath);
}
