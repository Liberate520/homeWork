package model.tree;

import java.io.IOException;

public interface Writable {
    void writeTree(FamilyTree tree) throws IOException;
}
