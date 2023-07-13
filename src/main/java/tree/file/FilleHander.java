package tree.file;

import java.io.*;

public class FilleHander implements Writeble {
    @Override
    public boolean saveing(Serializable serializable, String filepath) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath));
        objectOutputStream.writeObject(serializable);
        return true;
    }
    @Override
    public Object reading(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        return objectInputStream.readObject();
    }
}
