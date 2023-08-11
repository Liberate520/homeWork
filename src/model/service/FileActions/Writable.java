package model.service.FileActions;

import model.Human.Human;
import model.family_tree.FamilyTree;

public interface Writable{
    void setFilePath(String filePath);
    FamilyTree<Human> load();
    boolean save(FamilyTree<Human> tree);
}
