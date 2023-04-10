package filesystem.interfaces;

import java.io.Serializable;

import tree.interfaces.iTree;

public interface SaveLoad<E> extends Serializable {
    void save (iTree<E> treeToSave, String path);
    iTree<E> load (String path);
}
