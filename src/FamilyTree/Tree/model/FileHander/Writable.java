package FamilyTree.Tree.model.FileHander;

import java.io.Serializable;

public interface Writable {
    void save(Serializable serializable, String filePath);

    Object read(String filePath);

    void save(String path, Serializable obj);
}