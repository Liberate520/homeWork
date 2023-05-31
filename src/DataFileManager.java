import java.io.*;

public class DataFileManager implements Serializable {
    public static void saveData(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("FamilyTreeData.df"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    public static Object loadData() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FamilyTreeData.df"));
        //objectInputStream.close();
        return objectInputStream.readObject();
    }

}