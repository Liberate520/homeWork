package tree.model.saveLoad;

import java.io.*;

public class Write implements Writable {
    private final String FILEPATH = "saveTree.txt";

    public boolean save(Serializable serializable, String FILEPATH) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILEPATH))) {
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

    public String getFILEPATH() {
        return FILEPATH;
    }
}
