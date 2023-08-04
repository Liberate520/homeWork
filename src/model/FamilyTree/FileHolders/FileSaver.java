package model.FamilyTree.FileHolders;

import model.FamilyTree.FamilyTree;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileSaver implements Savable{
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
}
