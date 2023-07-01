package FamilyTree.model.fileHandler;

import FamilyTree.model.tree.FamilyTree;

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
    public FamilyTree load(String path) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (FamilyTree) objectInputStream.readObject();
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
