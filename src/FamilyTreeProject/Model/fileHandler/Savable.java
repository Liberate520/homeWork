package model.fileHandler;
import java.io.Serializable;

import model.familyTree.FamilyTree;
import model.human.FamilyTreeObject;

public interface Savable {
    public boolean save(Serializable serializable, String path);
    public FamilyTree<FamilyTreeObject> load(String path);
}
