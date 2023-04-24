package model.file;

import model.tree.FamilyTree;

public interface InterfaceFile {
    FamilyTree readFromFile(String fileName);

    boolean saveToFile(FamilyTree humans, String fileName);
}
