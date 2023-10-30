package family_Tree.writer;

import java.io.Serializable;

public interface Writable {

    boolean save (Serializable serializable, String filepath);
    Object read (String filepath);
}
