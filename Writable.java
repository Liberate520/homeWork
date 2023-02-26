package Java_OOP.homeWork;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {
    void write(String path, String fileName, Object object) throws FileNotFoundException, IOException;
    FamilyTree load(String path, String fileName) throws FileNotFoundException, IOException, ClassNotFoundException;
}
