package Hw.sem1;

import java.io.IOException;

public interface DataStorage<T> {
    void saveToFile(String fileName, T data) throws IOException;
    T loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
