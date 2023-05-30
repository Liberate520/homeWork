package homeWork.tree2;


import java.io.IOException;

public interface ToSaveAndLoadInterface {
    void save(FamilyTree familyTree) throws IOException;
    FamilyTree load() throws IOException, ClassNotFoundException;
}
