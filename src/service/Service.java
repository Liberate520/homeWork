package service;

import entity.Mammal;
import familytree.FamilyTree;
import write.Writable;

import java.util.List;

public interface Service {
    void addFamilyTree(FamilyTree familyTree);

    Mammal getMember(String name);
    FamilyTree getTree();
    FamilyTree getTree(int index);
    List<String> getTreeNames();
    void sortTree(int sortType);
    List<String> getWriterDescriptions();
    int getFileType(int writerIndex);
    String saveTree(int fileType);
    String loadTree(int fileType);
}