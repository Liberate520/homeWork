package Model;

import java.io.*;
import java.util.List;

public class FileDataIO implements DataIO {
    @Override
    public void saveToFile(List<Human> list, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
        }
    }

    @Override
    public List<Human> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Human>) ois.readObject();
        }
    }
}


