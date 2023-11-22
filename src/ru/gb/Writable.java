package ru.gb;

import java.io.IOException;

public interface Writable {
    void saveToFile(String fileName, Object object) throws IOException;
    Object readFromFile(String fileName) throws IOException, ClassNotFoundException;
}
