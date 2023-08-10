package model.save;

import model.familyTree.FamilyTree;
import model.human.Human;

import java.io.IOException;

public interface FamilyTreeFileIO {
    String filename = "family_tree_data.ser";

    void saveToFile(FamilyTree<Human> familyTree, String filename) throws IOException;

    FamilyTree<Human> loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
