package UtilsPack;

import TreePack.FamilyTree;

import java.io.*;

public class StorageTree implements Savable {
    public boolean writeTree (Serializable serializable, String fileName){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public FamilyTree restoreTree (String fileName){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            FamilyTree tmp = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
            return tmp;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
