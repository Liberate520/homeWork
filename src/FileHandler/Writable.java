package FileHandler;

import FamilyTree.FamilyTree;

public interface Writable {
    void writeToFile(FamilyTree familyTree, String path);
    FamilyTree readFromFile(String path);
}
