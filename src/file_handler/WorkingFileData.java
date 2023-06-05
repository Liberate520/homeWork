package file_handler;

import family_tree.FamilyTree;

import java.io.IOException;

public interface WorkingFileData {
    void save(FamilyTree familyTree) throws IOException;

    FamilyTree load() throws IOException, ClassNotFoundException;
}
