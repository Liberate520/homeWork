package family_tree.fileHandlers;

import java.io.FileNotFoundException;
import java.io.IOException;

import family_tree.familyTree.FamilyTree;

public interface Writable {

    void saveTree(FamilyTree familyTree, boolean rewrite) throws IOException, ClassNotFoundException;

    FamilyTree loadTree() throws FileNotFoundException, IOException, ClassNotFoundException;
}
