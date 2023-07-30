package Home_work.Writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHendler implements Writable {
    @Override
    public boolean save(Serializable serializable, String fileDB) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileDB))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String fileDB) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileDB))) {
            return ObjectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
