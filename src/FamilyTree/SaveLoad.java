package FamilyTree;

import java.io.IOException;
import java.io.Serializable;

public interface SaveLoad {
    void save(Serializable o, String path) throws IOException, ClassNotFoundException;

    Object load (String path) throws IOException, ClassNotFoundException;
}
