import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileHandler implements Saveable, Readable {
    @Override
    public void save(List<Human> humalis) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(".//homeWorkOOP.//src.//familytrees.out"));
        objectOutputStream.writeObject(humalis);
        objectOutputStream.close();
    }

    /**
     * @param humalis
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void read() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(".//homeWorkOOP.//src.//familytrees.out"));
        List<Human>  humalis = (List<Human>) objectInputStream.readObject();
        objectInputStream.close();

    }

    public void read(List<Human> humanlist) {
    }
}
