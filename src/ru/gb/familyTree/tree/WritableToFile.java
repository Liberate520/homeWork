package ru.gb.familyTree.tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface WritableToFile {
    void writeObject(Object object, String filename) throws IOException;
    Object restoreObject(String filename) throws IOException, ClassNotFoundException;
}
