package model.fileHandler;

import model.FamilyTreeModel;
import java.io.*;

public class SaveLoadFile implements Writeable {
    @Override
    public void saveToFile(String fileName, FamilyTreeModel tree) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(tree);
        objectOut.close();
        fileOut.close();
    }

    public FamilyTreeModel loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fileName);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        FamilyTreeModel tree = (FamilyTreeModel) objectIn.readObject();
        objectIn.close();
        fileIn.close();
        return tree;
    }

}