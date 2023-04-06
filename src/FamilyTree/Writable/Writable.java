package FamilyTree.Writable;

import java.io.IOException;
import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable, String pathName) throws IOException;

    Object load(String pathName) throws IOException, ClassNotFoundException;
}
