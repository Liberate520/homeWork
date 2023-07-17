package FamilyTree.Model.File;

import FamilyTree.Model.tree.Tree;

import java.io.IOException;

public interface Writeable {


    void save(Tree tree) throws IOException;

    Tree load() throws IOException, ClassNotFoundException;
}
