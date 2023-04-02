import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;

public class FileHandler implements Writable {

    @Override
    public void save(Object object) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("FamilyTree.txt"))) {
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("FamilyTree.txt"))) {
            FamilyTree result = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
