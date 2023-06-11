ackage three;

import java.io.*;

public class FileHandler implements Serializable {

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject();
        objectOutputStream.writeObject();
        objectOutputStream.flush()

    ObjectInputStream objectInputStream = new ObjectInputStream(
            new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    Human fatherRestoredFromByte = (Human) objectInputStream.readObject();
    Human motherRestoredFromByte = (Human) objectInputStream.readObject();
        objectInputStream.close();

}
