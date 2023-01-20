package tree;

import java.io.IOException;

public interface Writable {
    void writeToFile(FamilyTree tree) throws IOException;
    FamilyTree readFromFile(FamilyTree tree);
}
