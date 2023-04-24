import java.io.*;
import java.util.List;

public interface FileIO {
    void saveToFile(List<Human> list, String fileName) throws IOException;

    List<Human> loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
