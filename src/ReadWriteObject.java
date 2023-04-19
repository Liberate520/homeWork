import java.io.*;
import java.util.List;

public class ReadWriteObject implements ReadWriteData{
    @Override
    public void writeData(List lstObjects) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Human.out"));
        objectOutputStream.writeObject(lstObjects);
        objectOutputStream.close();
    }

    @Override
    public List readData() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Human.out"));
        List lstObjects = (List) objectInputStream.readObject();
        objectInputStream.close();
        return lstObjects;
    }
}
