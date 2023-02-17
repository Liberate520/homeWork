import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Repo implements FileData{

    @Override
    public void save(Serializable serializable, String filename) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public Object read(String filename) throws IOException, ClassNotFoundException {
        List<Object> result = new LinkedList<>();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        result = (List<Object>) objectInputStream.readObject();
        objectInputStream.close();
        return result;
    }
}