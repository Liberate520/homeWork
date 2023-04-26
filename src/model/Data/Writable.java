package model.Data;

import model.Tree.FamilyTree;

public interface Writable {

    void dataOutput(FamilyTree familyTree, String filePath);

    FamilyTree deserialization(String filePath);
}
