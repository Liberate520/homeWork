package family_tree.FamilyTree.Tree;

import family_tree.FamilyTree.Tree.FamilyTree;

import java.io.IOException;

public interface Serialise {
    void write(FamilyTree tree) throws IOException;
    FamilyTree read() throws IOException;

}
