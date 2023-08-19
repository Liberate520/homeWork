package Model;

import java.io.*;

public class FileHandler implements Writable, Serializable {
    @Override
    public boolean save(FamilyTree<HouseHold> familyTree, String filePath) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(familyTree);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}