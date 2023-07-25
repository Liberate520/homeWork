import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class WriteToFile implements Serializable {
    private String path;

    public WriteToFile(String path) {
        this.path = path;
    }

    public void write(FamilyTree ft) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(ft);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
