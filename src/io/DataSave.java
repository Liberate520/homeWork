package io;

import java.io.IOException;

import human.Human;
import tree.FamilyTree;

public interface DataSave {
    void saveData(FamilyTree<Human> familyTree) throws IOException, ClassNotFoundException;
}
