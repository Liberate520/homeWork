package model.filesystem.interfaces;

import java.io.Serializable;
import java.util.List;


public interface SaveLoad<E> extends Serializable {
    void save (List<E> treeToSave, String path);
    List<E> load (String path);
}
