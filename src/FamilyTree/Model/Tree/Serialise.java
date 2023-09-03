package family_tree.FamilyTree.Model.Tree;

import java.io.IOException;

public interface Serialise {
    void write(FamilyTree tree) throws IOException;
    FamilyTree read() throws IOException;

}
