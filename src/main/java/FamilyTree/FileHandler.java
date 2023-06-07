package FamilyTree;

import java.io.*;

public class FileHandler implements FormatHandler{
    @Override
    public void save(Object obj, String file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
        objectOutputStream.writeObject(obj);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Object load(String file) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
