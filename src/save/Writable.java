package save;

import tree.FamilyTree;

import java.io.IOException;

public interface Writable {
    void save(FamilyTree familyTree, String fileAddress) throws IOException;
    FamilyTree read(String fileAddress) throws IOException, ClassNotFoundException;
}
