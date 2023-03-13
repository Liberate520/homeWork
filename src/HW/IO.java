package HW;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IO implements Loading, Save {
    @Override
    public Serializable load(String path) {
        Serializable personRestored = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Family.txt"))) {
            personRestored = (Serializable) ois.readObject();
            System.out.println("Данные загруженны!");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return personRestored;
    }

    @Override
    public void save(String path, Serializable obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Family.txt"))) {
            oos.writeObject(obj);
            System.err.println("Данные сохранены !");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
