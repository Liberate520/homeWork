package model;

import java.io.IOException;
import java.util.List;

public interface GenealogyTreeService<T extends FamilyMember> {
    void addPerson(String key, T person);
    T getPerson(String key);
    void addChild(String parentKey, String childKey);
    GenealogyTree<? extends FamilyMember> getGenealogyTree(); // Замените GenealogyTree<T> на GenealogyTree<? extends FamilyMember>
    void saveGenealogyTree(String filename) throws IOException;
    void loadGenealogyTree(String filename) throws IOException;
    List<T> sortByName();
    List<T> sortByDateOfBirth();
}