import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Serialize {
    private String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void writeToFile(Serializable toWrite) {
        try {
            FileOutputStream file = new FileOutputStream(this.path);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(toWrite);
            out.close();
        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Serializable readFromFile() {
        Serializable recovered = null;
        try {
            FileInputStream file = new FileInputStream(this.path);
            ObjectInputStream in = new ObjectInputStream(file);
            recovered = (Serializable) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return recovered;
    }
    
}