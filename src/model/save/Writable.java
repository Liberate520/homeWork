package model.save;

import model.familyTree.FamilyTree;
import model.human.Human;

import java.io.Serializable;

public interface Writable {
    boolean save(FamilyTree<Human> tree);
    FamilyTree<Human> read();
    void setFilePath(String filePath);
}