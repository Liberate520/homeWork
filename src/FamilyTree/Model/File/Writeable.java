package FamilyTree.Model.File;


import FamilyTree.Model.tree.Being;
import FamilyTree.Model.tree.Tree;
import FamilyTree.Model.tree.TreeAble;

import java.io.IOException;

public interface Writeable {


    void save(TreeAble tree) throws IOException;

    TreeAble  load() throws IOException, ClassNotFoundException;
}
