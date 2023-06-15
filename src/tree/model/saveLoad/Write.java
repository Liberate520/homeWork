package tree.model.saveLoad;

import java.io.*;

public class Write implements Writable {
    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filePath))) {
            output.writeObject(serializable);
            return true;
        } catch (
                Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public Object load(String filePath) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filePath))) {
            return input.readObject();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
