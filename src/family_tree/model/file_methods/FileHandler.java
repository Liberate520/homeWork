package family_tree.model.file_methods;

import java.io.*;

public class FileHandler implements Writable{
    public void writeFamilyTree(Serializable serializable, String filePath) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(serializable);
    }

    public Serializable readFamilyTree(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (Serializable)objectInputStream.readObject();
        }
    }