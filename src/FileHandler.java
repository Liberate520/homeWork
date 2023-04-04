import javax.imageio.IIOException;
import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void save(Writable serializable) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("src/out.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(serializable);
        }
        catch (IIOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public Writable load() throws ClassNotFoundException, InvalidObjectException {
        try (FileInputStream fis = new FileInputStream("src/out.txt ");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Writable object = (Writable) ois.readObject();
            return object;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        throw new InvalidObjectException("Object fail");
    }
}
