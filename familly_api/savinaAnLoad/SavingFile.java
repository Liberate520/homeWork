package familly_api.savinaAnLoad;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import familly_api.familytree.FamilywTree;

import java.io.File;
import java.io.FileInputStream;

public class SavingFile implements Interf<FamilywTree>{

    private FamilywTree yorObject;

    private void createFile(String nameFile) {
        File file = new File(nameFile);
    }

    public void saveFile(FamilywTree yorObject, String nameFile) {
        this.yorObject = yorObject;
        createFile(nameFile);
        try {
            FileOutputStream store = new FileOutputStream(nameFile);
            ObjectOutputStream toStore = new ObjectOutputStream(store);
            toStore.writeObject(yorObject);
            toStore.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FamilywTree loadFile(String nameFile) {
        FamilywTree family = null;
        try (ObjectInputStream toStore = new ObjectInputStream(new FileInputStream(nameFile))) {
            family = (FamilywTree) toStore.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return family;
    }
}
