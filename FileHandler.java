import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable{

    public void writeFamilyTree(Serializable serializable, String filePath) {
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(serializable);
        } catch (IOException ser) {
            ser.printStackTrace();
        }
    }

    public Serializable readFamilyTree(String filePath) {
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return (Serializable)objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException ser) {
            ser.printStackTrace();
            return null;
        }
    }
}