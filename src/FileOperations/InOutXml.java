package FileOperations;

import java.io.*;

public class InOutXml implements InOut {

    public void saveData(Serializable obj, String fileName) throws IOException {
        fileName = fileName + ".xml";
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close();
    }

    public Serializable loadData(String fileName) throws IOException, ClassNotFoundException {
        fileName = fileName + ".xml";
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Serializable obj = (Serializable) ois.readObject();
        ois.close();
        return obj;
    }

}
