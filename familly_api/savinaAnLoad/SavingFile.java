package familly_api.savinaAnLoad;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import familly_api.familytree.FamilywTree;
import familly_api.human.Node;

import java.io.File;
import java.io.FileInputStream;

public class SavingFile implements Interf<FamilywTree<Node>>{

    private FamilywTree<Node> yorObject;

    private void createFile(String nameFile) {
        File file = new File(nameFile);
    }

    public void saveFile(FamilywTree<Node> yorObject, String nameFile) {
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

    public FamilywTree<Node> loadFile(String nameFile) {
        this.yorObject = null;
        try (ObjectInputStream toStore = new ObjectInputStream(new FileInputStream(nameFile))) {
            yorObject = (FamilywTree<Node>) toStore.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return yorObject;
    }
}
