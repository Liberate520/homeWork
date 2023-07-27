package save;

import model.familyTree.FamilyTree;
import model.human.Human;

import java.io.IOException;

public interface FamilyTreeFileIO {
    void saveToFile(FamilyTree<Human> familyTree, String filename) throws IOException;
    FamilyTree<Human> loadFromFile(String filename) throws IOException, ClassNotFoundException;
}

