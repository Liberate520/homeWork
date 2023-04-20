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

    }

    @Override
    public List<Human> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        return null;
    }
}