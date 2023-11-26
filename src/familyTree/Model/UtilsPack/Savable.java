package familyTree.Model.UtilsPack;

import java.io.Serializable;

public interface Savable<E> {
    boolean writeTree(Serializable serializable, String fileName);
    E restoreTree(String fileName);
}
