package FamilyTree.fileHandler;

import java.io.*;

public class FileHandler implements SaveLoader {
    @Override
    public boolean save(Serializable serializable, String path){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object load(String path) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return objectInputStream.readObject();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
