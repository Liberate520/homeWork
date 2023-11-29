package familyTree.Model.UtilsPack;

import familyTree.Model.TreePack.FamilyTree;
import familyTree.Model.TreePack.TreeItem;

import java.io.*;

public class StorageTree<E extends TreeItem<E>> implements Savable<FamilyTree<E>> {
    public boolean writeTree (FamilyTree<E> serializable, String fileName){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public FamilyTree<E> restoreTree (String fileName){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            FamilyTree<E> tmp = (FamilyTree<E>) objectInputStream.readObject();
            objectInputStream.close();
            return tmp;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
