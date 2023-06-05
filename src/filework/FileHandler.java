package filework;
import java.io.*;

/** сериализация и восстановление сериализуемых объектов */
public class FileHandler<T extends Serializable> implements CapableOfPreserving<T>, CapableOfRestore<T> {

    @Override
    public T read(String path) {
        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path));
            T object = (T)stream.readObject();
            stream.close();
            return object;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void save(String path, T object) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(path))) {
            stream.writeObject(object);
            stream.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
