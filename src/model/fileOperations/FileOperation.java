package model.fileOperations;

import model.familyTree.FamilyTree;

public interface FileOperation {
    void write(String fileName, FamilyTree tree);
    void read(String fileName);
}
