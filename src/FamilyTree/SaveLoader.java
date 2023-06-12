package FamilyTree;

import java.io.Serializable;

public interface SaveLoader {
    boolean save(Serializable serializable, String path);
    Object load(String path);
}
