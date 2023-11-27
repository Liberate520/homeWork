package model.service;

import model.fmilyTree.FamilyTree;

import java.io.*;
import java.util.List;

public class Saver implements Serializable{
    public boolean write (Object familyTree, String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(familyTree);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List read (String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            FamilyTree familyTree = new FamilyTree();
            return (List)(objectInputStream.readObject());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
