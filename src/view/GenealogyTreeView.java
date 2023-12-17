package view;

import model.GenealogyTree;
import model.Person;

import java.io.IOException;

public interface GenealogyTreeView {
    void displayGenealogyTree(GenealogyTree<?> genealogyTree);
    void loadGenealogyTree(String filename) throws IOException;
    void saveGenealogyTree(String filename) throws IOException;
    void addPerson(String key, Person person);
    void addChild(String parentKey, String childKey);
    void sortByNameAndDisplay();
    void sortByDateOfBirthAndDisplay();
}