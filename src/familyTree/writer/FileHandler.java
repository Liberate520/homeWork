package familyTree.writer;

import familyTree.familyTree.FamilyTree;

import java.io.*;

public class FileHandler {
    public static void serialization() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.txt"));
        FamilyTree testTree = new FamilyTree();
        oos.writeObject(testTree);
        oos.close();
    }
}
