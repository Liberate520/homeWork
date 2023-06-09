import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class WriteFile {
    public void write() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.txt"));
            objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
