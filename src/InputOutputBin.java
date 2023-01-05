
import java.io.*;

public class InputOutputBin implements IInputOutputable {

    @Override
    public void saveAs(Serializable obj, String filePathName) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filePathName));
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("Write error");
            e.printStackTrace();
        }
    }

    @Override
    public Serializable readFrom(String filePathName) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(filePathName));
            Serializable serializableRestored = (Serializable) objectInputStream.readObject();
            objectInputStream.close();
            return serializableRestored;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Read error.");
        }
        return null;
    }
}
