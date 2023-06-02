package filework;
import java.io.*;

/** сериализация и восстановление сериализуемых объектов */
public class FileHandler implements CapableOfPreserving, CapableOfRestore {

    @Override
    public Serializable read(String path) {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path));
            Serializable object = (Serializable) stream.readObject();
            stream.close();
            return object;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void save(String path, Serializable object) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(object);
            stream.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
