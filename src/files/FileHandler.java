package files;
import java.io.*;

public class FileHandler implements Writable, Serializable {



    @Override
    public boolean save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("file.txt"))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("file.txt"))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }



}
