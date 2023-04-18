package Saving;

import Program.FamilyTree;

import java.io.IOException;

public interface Saveable {
    void saveFamilyTreeAs(FamilyTree familyTree, String path) throws IOException;
    FamilyTree getFamilyTreeFrom(String path) throws IOException, ClassNotFoundException;
}
