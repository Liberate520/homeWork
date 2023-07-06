package ru.java_oop.family_tree.file_handler;

import java.io.IOException;

public interface SavableAndReadable {

    void writeObjToFile() throws IOException;

    Object readObjFromFile() throws IOException, ClassNotFoundException;
}
