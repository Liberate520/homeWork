package FamilyTree.FamilyTree.Model.Utils;

import java.io.Serializable;

public interface Savable<E extends Serializable> {
    boolean writeTree(E serializable, String fileName);
    E restoreTree(String fileName);
}