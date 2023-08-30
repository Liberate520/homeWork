package fileWriter;

import FamilyTree.Tree;
import java.io.IOException;

public interface Writable {
    void saveFile(Tree family) throws IOException;
    Tree loadFile() throws IOException, ClassNotFoundException;


}