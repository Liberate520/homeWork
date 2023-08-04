package model.FamilyTree.FileHolders;

import model.FamilyTree.FamilyTree;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FileReader implements Readable {
    String PATH = "src/database/database.txt";
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
