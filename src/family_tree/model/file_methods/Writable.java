package family_tree.model.file_methods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;


public interface Writable {
    void writeFamilyTree(Serializable serializable, String filePath) throws IOException;
    Serializable readFamilyTree(String filePath) throws IOException, ClassNotFoundException;
}
