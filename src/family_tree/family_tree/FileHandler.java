package family_tree.family_tree;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public Serializable load(String path) {
        Serializable personRes = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path))) {
            personRes = (Serializable) objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return personRes;
    }

    @Override
    public void save(String path, Serializable obj) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path))){
            objectOutputStream.writeObject(obj);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
