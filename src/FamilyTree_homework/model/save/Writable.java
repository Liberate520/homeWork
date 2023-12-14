package FamilyTree_homework.model.save;


import FamilyTree_homework.model.Humans.Human;
import FamilyTree_homework.model.familyTree.FamilyTree;

public interface Writable {
    boolean save(FamilyTree<Human> tree);
    FamilyTree<Human> read();
    void setFilePath(String filePath);
}
