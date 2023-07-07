package family_tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {

    void saveTree(FamilyTree familyTree, boolean rewrite) throws IOException, ClassNotFoundException;

    FamilyTree loadTree() throws FileNotFoundException, IOException, ClassNotFoundException;
}
