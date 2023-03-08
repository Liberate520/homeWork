package Java_OOP.homeWork;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {
    void write(String path, Object object) throws FileNotFoundException, IOException;

    FamilyTree load(String path) throws FileNotFoundException, IOException, ClassNotFoundException;
}
