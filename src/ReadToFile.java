import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ReadToFile implements Serializable {
    private String path;

    public ReadToFile(String path) {
        this.path = path;
    }

    public FamilyTree read() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            return (FamilyTree) objectInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
