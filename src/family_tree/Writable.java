package family_tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {

    void SaveTree(FamilyTree familyTree, boolean rewrite) throws IOException, ClassNotFoundException;

    void LoadTree() throws FileNotFoundException, IOException;
}
