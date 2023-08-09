package family_tree.model.file_methods;

import java.io.Serializable;


public interface Writable {
    void writeFamilyTree(Serializable serializable, String filePath);
    Serializable readFamilyTree(String filePath);
}
