package model.fileHandler;

import model.FamilyTreeModel;
import java.io.IOException;

public interface Writeable {
    void saveToFile(String fileName, FamilyTreeModel tree) throws IOException;
    FamilyTreeModel loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}