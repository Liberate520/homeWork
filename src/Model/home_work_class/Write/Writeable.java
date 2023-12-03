package Model.home_work_class.Write;

import Model.home_work_class.FamilyTree.FamilyTree;
import Model.home_work_class.Human.Human;

import java.io.IOException;

public interface Writeable {
    void write(FamilyTree<Human> tree) throws IOException;
    FamilyTree<Human> read() throws IOException, ClassNotFoundException;
}
