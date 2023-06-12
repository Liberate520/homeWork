package Hw.sem1;

import java.io.IOException;

public interface DataStorage {
    void  saveToFile(String fileName) throws IOException;
    void loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
