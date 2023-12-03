package Model.home_work_class.Write;

import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.Human.Human;

import java.io.IOException;

public interface WriteRead {
    boolean fileWriter(String path, FamilyTree<Human> FamilyTree);
    FamilyTree<Human> fileReader(String path);
}
