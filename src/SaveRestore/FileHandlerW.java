package src.SaveRestore;
import java.io.*;
public class FileHandlerW implements Write {
    private final String path;

    public FileHandlerW() {
        this.path = "sFT.ser";
    }
    @Override
    public boolean write(Serializable obj) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(path));
            objectOutput.writeObject(obj);
            objectOutput.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
