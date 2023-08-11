package model.service.FileActions;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler {

    public Serializable load(String filePath) {
        Serializable personRestored = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filePath))) {
            personRestored = (Serializable) objectInputStream.readObject();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return personRestored;
    }

    
    boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            return false;
        }
    }
    
}
