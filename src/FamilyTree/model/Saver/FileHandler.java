package FamilyTree.model.Saver;

import FamilyTree.model.FT.FamTree;
import FamilyTree.model.HR.Human;

import java.io.*;

public class FileHandler {
    public boolean save(Serializable savingStream, String savePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(savePath))) {
            outputStream.writeObject(savingStream);
//            outputStream.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object load(String savePath) {
        try (ObjectInputStream savedStream = new ObjectInputStream(new FileInputStream(savePath))) {
            return savedStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




//    @Override
//    public Object load(String savePath) {
//        FamTree familyTree = new FamTree();
//        return new FamTree() /*(new ObjectInputStream(filePath))*/;
//    }
}
