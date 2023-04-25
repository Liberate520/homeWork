import java.io.*;
import java.util.List;
import java.util.logging.FileHandler;

public class FileHandlerWrapper implements FileIO {
    private FileHandler fileHandler;

    public FileHandlerWrapper(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

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