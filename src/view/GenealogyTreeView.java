package view;

import model.GenealogyTree;
import model.FamilyMember;

import java.io.IOException;

// Интерфейс для представления генеалогического древа
public interface GenealogyTreeView {
    void displayGenealogyTree(GenealogyTree<? extends FamilyMember> genealogyTree);
    void loadGenealogyTree(String filename) throws IOException;
    void saveGenealogyTree(String filename) throws IOException;
    void addPerson(String key, FamilyMember person);
    void addChild(String parentKey, String childKey);
    void sortByNameAndDisplay();
    void sortByDateOfBirthAndDisplay();
}