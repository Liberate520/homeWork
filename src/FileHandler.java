import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Saveble {
    @Override
    public void save(String path, Serializable serializable) {
        try (ObjectOutputStream saveStream = new ObjectOutputStream(new FileOutputStream(path))) {
            saveStream.writeObject(serializable);
        } catch (FileNotFoundException e) {
            System.out.println("Не удается сохранить файл");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Object load(String path) {
        try (ObjectInputStream loadStream = new ObjectInputStream(new FileInputStream(path))) {
            return loadStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
