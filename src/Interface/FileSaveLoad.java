package Interface;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.Serializable;

// import interface.SaveLoad;

public class FileSaveLoad implements SaveLoad {
    private static String path;

    public FileSaveLoad(String path) {
        this.path = path;
    }

    @Override
    public Object LoadAs() {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        new FileInputStream(path));
                Object obj = objectInputStream.readObject();
                objectInputStream.close();
                return obj;
            } catch (Exception e) {
                System.out.println("Could not read from file");
                return null;
            }

    }

    @Override
    public void SaveAs(Serializable obj) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("Could not save to file.");
        }
    }


}
