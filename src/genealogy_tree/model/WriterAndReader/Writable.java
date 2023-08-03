package genealogy_tree.model.WriterAndReader;

import java.io.Serializable;

public interface Writable {
    boolean saves(Serializable serializable, String filePath);

    Object read(String filePath);
}
