import java.io.*;

public class SaveAndLoad{

    public void saveData(Serializable obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close();
    }

    public Serializable loadData(Serializable obj, String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);

        obj = (Serializable) ois.readObject();
        ois.close();
        return obj;
    }

}
