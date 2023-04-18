package Saving;

import Program.FamilyTree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Saveable {
    void saveAs(FamilyTree familyTree, String path) throws IOException;
    FamilyTree getFamilyTreeFrom(String path) throws IOException, ClassNotFoundException;
}
