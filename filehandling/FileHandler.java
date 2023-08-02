package homeWork.filehandling;

import homeWork.familytree.Human;

import java.io.IOException;
import java.util.List;

public interface FileHandler {
    void writeToFile(List<Human> humans, String filename) throws IOException;
    List<Human> readFromFile(String filename) throws IOException;
}

