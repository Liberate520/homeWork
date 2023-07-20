package GenerationTree.Model.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler<T> implements FileWriter, FileReader<T> {

    @Override
    public boolean save(Serializable serializable, String filePath) {
        var isFileExist = createFile(filePath);
        if (!isFileExist)
            return false;
        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public T read(String filePath) {
        try (var objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    private boolean createFile(String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            return file.getParentFile().mkdirs();
        }
        return true;
    }
}
