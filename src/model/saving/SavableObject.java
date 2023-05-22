package model.saving;

import model.familyTree.FamilyTree;

import java.io.IOException;

public interface SavableObject {
    void saveObjectAs(Object object, String path) throws IOException;
}
