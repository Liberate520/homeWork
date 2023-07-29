package model.FamilyTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHolder implements Writable {
    String PATH = "src/database/database.txt";

    @Override
    public void save(FamilyTree tree) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(PATH))) {
            objectOutputStream.writeObject(tree);
        }catch (Exception e){
            System.out.println("Error" + e);
        }
    }

    @Override
    public FamilyTree read() {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(PATH))) {
            FamilyTree tree = (FamilyTree) objectInputStream.readObject();
            return tree;
        }catch (Exception e){
            System.out.println("Error" +e);
        }
        return null;
    }


}
