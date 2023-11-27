package ru.medved_sa.tree_family.model.save;


import ru.medved_sa.tree_family.model.familyTree.EntityCreation;
import ru.medved_sa.tree_family.model.familyTree.FamilyTree;

import java.io.*;

public class FileHandler<E extends EntityCreation<E>> implements Writable<FamilyTree<E>> {
    private String filePath = "src/ru/medved_sa/tree_family/model/save/familyTree.out";

    public String getFilePath() {
        return filePath;
    }

    public boolean saveFile(Serializable serializable, String filePath ) {
        filePath = getFilePath();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public FamilyTree<E> readFile(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(getFilePath()))) {
            return (FamilyTree<E>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}
