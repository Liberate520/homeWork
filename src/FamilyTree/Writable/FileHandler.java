package FamilyTree.Writable;

import java.io.*;

public class FileHandler implements Writable {

    public FileHandler() {
    }

    @Override
    public void save(Serializable serializable, String pathName) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializable);
        } catch (IOException ioException) {
            ioException.printStackTrace(System.out);
        }
    }

    @Override
    public Object load(String pathName) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathName));
            return objectInputStream.readObject();
        } catch (IOException ioException) {
            ioException.printStackTrace(System.out);
            return null;
        }
    }
}
