package family_tree.writer;

import family_tree.family_tree.FamilyTree;

import java.io.File;
import java.io.IOException;

public interface WritableLoadable {
    public void writToFile(FamilyTree familyTree, File file) throws IOException, ClassNotFoundException;
    public FamilyTree readFromFile(File file) throws IOException, ClassNotFoundException;
}
