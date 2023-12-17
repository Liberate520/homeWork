package model;

import java.io.IOException;
import java.util.List;

public interface GenealogyTreeService<T extends Person> {
    void addPerson(String key, T person);
    T getPerson(String key);
    void addChild(String parentKey, String childKey);
    GenealogyTree<T> getGenealogyTree();
    void saveGenealogyTree(String filename) throws IOException;
    void loadGenealogyTree(String filename) throws IOException;
    List<T> sortByName();
    List<T> sortByDateOfBirth();
}