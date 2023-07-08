package family_tree;


import java.io.*;

public class FileHandler implements Writeble {
    @Override
    public boolean save(Serializable object, String filepath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath))) {
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filepath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath))) {
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
