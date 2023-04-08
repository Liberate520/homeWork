package filesystem.interfaces;

import java.io.Serializable;

import tree.interfaces.iTree;

public interface SaveLoad extends Serializable {
    void save (iTree treeToSave, String path);
    iTree load (String path);
}
