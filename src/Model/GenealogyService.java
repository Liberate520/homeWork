package Model;

import Model.Tree.FamilyTree;

import java.io.IOException;

public interface GenealogyService {
    void loadFamilyTree() throws IOException, ClassNotFoundException;
    void saveFamilyTree() throws IOException;
    // Другие методы, связанные с работой с генеалогическим деревом
}
