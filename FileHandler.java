import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writeble {
 @Override
    public boolean save (Serializable object, String filepath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Object read(String filepath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"))) {
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}   

