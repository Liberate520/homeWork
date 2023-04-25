package model.familyTreeApi.fileHandler;
import java.io.IOException;

import model.familyTreeApi.FamilyTree;
import model.familyTreeApi.Human;

public interface WriterReader {
    void save(FamilyTree<Human> tree, String fileAddress) throws IOException;
    FamilyTree<Human> read(String fileAddress) throws IOException, ClassNotFoundException;
}