import java.io.*;
import java.util.Base64;
import java.util.List;

public class Save implements Serializable, FileOperations {
    public void writeExternal(Human human, String filePath) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(human);
        outputStream.close();
    }

    public Human readExternal(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
        Human human = (Human) inputStream.readObject();
        inputStream.close();
        return human;
    }
}