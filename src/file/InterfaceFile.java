package file;

import tree.FamilyTree;

public interface InterfaceFile {
    FamilyTree readFromFile(String fileName);

    void saveToFile(FamilyTree humans, String fileName);
}
