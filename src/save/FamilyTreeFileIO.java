package save;

import model.familyTree.FamilyTree;

import java.io.IOException;

public interface FamilyTreeFileIO {
    void saveToFile(FamilyTree familyTree, String filename) throws IOException;
    FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException;
}

