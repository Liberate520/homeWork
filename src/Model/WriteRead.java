package Model;

import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.Human.Human;

public interface WriteRead {
    boolean fileWriter(String path, FamilyTree<Human> FamilyTree);
    FamilyTree<Human> fileReader(String path);
}
