package model.writer;

import model.familyTree.FamilyTree;
import model.human.Human;


public interface Writable {
    boolean save(FamilyTree<Human> tree);
    FamilyTree<Human> read();
    void setFilePath(String filePath);
}
