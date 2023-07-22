package readWrite;

import java.io.*;

public class FileHandler implements Writeable {
    private final String PATH = "src\\family_tree.txt";

    @Override
    public boolean write(Serializable obj) {
        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(PATH, false))) {
            outStream.writeObject(obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(PATH))) {
            return inStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
