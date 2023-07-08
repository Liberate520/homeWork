package family_tree.fileHandlers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable {
    public boolean save(Serializable serializable, String filePath) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;    
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
           return objectInputStream.readObject(); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
