package homeWork_OOP_family_tree;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import homeWork_OOP_family_tree.infoHuman.FamilywTree;

import java.io.File;
import java.io.FileInputStream;

public class SavingFile {
    private String whereToStore;
    FamilywTree result;

    public FamilywTree getResult() {
        return result;
    }

    public SavingFile(String whereToStore) {
        File file = new File(whereToStore);
        this.whereToStore = whereToStore;
    }

    public void toStore(FamilywTree yorObject) {
        try {
            FileOutputStream store = new FileOutputStream(this.whereToStore);
            ObjectOutputStream toStore = new ObjectOutputStream(store);

            toStore.writeObject(yorObject);

            toStore.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public FamilywTree pullFromFile() throws Exception{

            FileInputStream store = new FileInputStream(this.whereToStore);
            ObjectInputStream toStore = new ObjectInputStream(store);
            FamilywTree family = (FamilywTree) toStore.readObject();
            toStore.close();
            return family;
    }
}
