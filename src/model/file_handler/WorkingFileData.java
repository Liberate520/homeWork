package model.file_handler;

import model.family_tree.FamilyTree;

import java.io.IOException;

public interface WorkingFileData {
    void save(FamilyTree familyTree) throws IOException;

    FamilyTree load() throws IOException, ClassNotFoundException;
}
