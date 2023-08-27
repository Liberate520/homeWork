package fileWriter;

import FamilyTree.Tree;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Writable {
    void saveFile(Tree family) throws IOException;
    Tree loadFile() throws IOException, ClassNotFoundException;


}