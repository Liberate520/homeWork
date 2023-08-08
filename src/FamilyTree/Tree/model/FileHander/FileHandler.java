package FamilyTree.Tree.model.FileHander;

import FamilyTree.Tree.model.HumanGroup.Service;

import java.io.*;

public class FileHandler implements Writable {

    @Override
    public void save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


        @Override
        public Object read (String filePath){
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
                return objectInputStream.readObject();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    @Override
    public void save(String path, Serializable obj) {

    }

    public void save(Service humanList, String filePath) {
    }
}

    

