package tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {
    void writeTree(FamilyTree tree, String fileName) throws IOException;
}
