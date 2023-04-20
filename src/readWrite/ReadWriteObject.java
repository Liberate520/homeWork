package readWrite;

import java.io.*;
import java.util.List;

public class ReadWriteObject implements ReadWriteData{
    @Override
    public void writeData(List lstObjects, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(lstObjects);
        objectOutputStream.close();
    }

    @Override
    public List readData(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        List lstObjects = (List) objectInputStream.readObject();
        objectInputStream.close();
        return lstObjects;
    }
}
