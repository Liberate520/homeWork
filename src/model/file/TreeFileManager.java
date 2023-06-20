package model.file;

import java.io.*;

public class TreeFileManager implements FileManager {
    @Override
    public void saveData(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("FamilyTreeData.df"));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }

    @Override
    public Object loadData() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FamilyTreeData.df"));
        Object value = objectInputStream.readObject();
        objectInputStream.close();
        return value;
    }

}