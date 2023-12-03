package Model.home_work_class.Write;

import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.Human.Human;

import java.io.IOException;

public interface Writeable {
    void write(FamilyTree<Human> tree);
    void write(FamilyTree<Human> tree, String path);
    FamilyTree<Human> read();
    FamilyTree<Human> read(String path);
}
