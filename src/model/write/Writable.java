package model.write;

import model.familyTree.famTree.FamilyTree;
import model.human.Human;

public interface Writable {
    boolean save(FamilyTree<Human> tree);
    FamilyTree<Human> read();
    void setFilePath(String filePath);
}
