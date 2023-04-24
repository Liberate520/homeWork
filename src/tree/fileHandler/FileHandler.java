package tree.fileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable{

    @Override
    public void save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            System.out.println("Сохранить не удалось");
        }
    }

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println("Прочитать не удалось");
            return null;
        }
    }
}
