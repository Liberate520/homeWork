package ru.home.familyTree;

import ru.home.familyTree.family_Tree.FamilyTree;

import java.io.*;
import java.io.Serializable;


public class FileHandler implements Writeble {
    @Override
    public void write(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
           return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}


