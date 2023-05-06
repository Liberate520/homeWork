package SaveLoad;

import java.io.*;

public class SaveDoc implements Saveable{
    @Override
    public boolean save(Serializable obj) throws IOException {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("Java_OOP_homeWork\\src\\treeSave.doc"));
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Serializable load() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("Java_OOP_homeWork\\src\\treeSave.doc"));
            return (Serializable) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
