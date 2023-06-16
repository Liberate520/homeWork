package Hw.sem1;

import java.io.IOException;

public interface DataStorage {
    void saveToFile(String fileName) throws IOException;
    FamilyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
