package FamilyTree.model.save;

import java.io.Serializable;

public interface FileService {
    boolean save(Serializable serializable, String filePath);
    Object read(String filePath);
}
