package service;

import entity.Mammal;
import familytree.FamilyTree;

import java.util.List;

public interface Service {
    void addFamilyTree(FamilyTree familyTree);

    Mammal getMember(String name);
    FamilyTree getTree();
    FamilyTree getTree(int index);
    List<String> getTreeNames();
    void sortTree(int sortType);
    String saveTree(int fileType);
    String loadTree(int fileType);
}