package Interface;

import java.io.Serializable;
import Class.Tree;

public interface SaveLoad extends Serializable {
    void Save (Tree treeToSave, String path);
    Tree Load (String path);
}
