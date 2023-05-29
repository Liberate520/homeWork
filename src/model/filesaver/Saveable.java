package model.filesaver;
import model.familytree.FamilyTree;

import java.io.Serializable;

public interface Saveable extends Serializable {
    boolean save(Serializable serializable, String path);
    FamilyTree read(String path);
}
