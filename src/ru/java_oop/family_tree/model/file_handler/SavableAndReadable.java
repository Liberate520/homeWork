package ru.java_oop.family_tree.model.file_handler;

import java.io.IOException;

public interface SavableAndReadable {

    void writeObjToFile(Object obj) throws IOException;

    Object readObjFromFile() throws IOException, ClassNotFoundException;
}
