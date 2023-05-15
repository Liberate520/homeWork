package Model;

import java.io.IOException;
import java.util.List;

public interface DataIO {
    void saveToFile(List<Human> list, String fileName) throws IOException;

    List<Human> loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}


