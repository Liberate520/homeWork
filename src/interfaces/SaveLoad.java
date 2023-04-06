package interfaces;

import java.io.Serializable;

public interface SaveLoad extends Serializable {
    void save (iTree treeToSave, String path);
    iTree load (String path);
}
