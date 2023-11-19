package genealogy_tree.writer;

import java.io.Serializable;

public interface Writable {
    Boolean SaveObject(Serializable object);
    Object LoadObject();
}
