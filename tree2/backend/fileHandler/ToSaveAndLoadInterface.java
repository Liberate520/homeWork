package homeWork.tree2.backend.fileHandler;


import homeWork.tree2.backend.familyTree.FamilyTree;

import java.io.IOException;

public interface ToSaveAndLoadInterface {
    void save(FamilyTree familyTree) throws IOException;
    FamilyTree load() throws IOException, ClassNotFoundException;
}
