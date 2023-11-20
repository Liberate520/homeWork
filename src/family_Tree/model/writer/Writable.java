package family_Tree.model.writer;

import java.io.Serializable;

public interface Writable {

    boolean save (Serializable serializable, String filepath);
    Object read (String filepath);
}
