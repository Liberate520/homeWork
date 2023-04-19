import java.io.*;
import java.util.List;

public class ReadWriteByteArray implements ReadWriteData {

    ByteArrayOutputStream byteArrayOutputStream;

    @Override
    public void writeData(List lstObjects) throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(lstObjects);
        objectOutputStream.flush();
    }

    @Override
    public List readData() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        List lstObjects = (List) objectInputStream.readObject();
        objectInputStream.close();
        return lstObjects;
    }
}
