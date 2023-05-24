package fileHandler;
import java.io.Serializable;

import familyTree.FamilyTree;
import human.FamilyTreeObject;

public interface Savable {
    public boolean save(Serializable serializable, String path);
    public FamilyTree<FamilyTreeObject> load(String path);
}
