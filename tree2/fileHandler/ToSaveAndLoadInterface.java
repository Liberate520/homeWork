package homeWork.tree2.fileHandler;


import homeWork.tree2.familyTree.FamilyTree;

import java.io.IOException;

public interface ToSaveAndLoadInterface {
    void save(FamilyTree familyTree) throws IOException;
    FamilyTree load() throws IOException, ClassNotFoundException;
}
