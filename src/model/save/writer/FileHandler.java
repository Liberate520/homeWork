package model.save.writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import model.human.Human;
import model.tree.FamilyTree;

public class FileHandler implements Writable {
    @Override
    public Object save(Serializable serializable, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object loading(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            Object object = objectInputStream.readObject();
            if (object instanceof FamilyTree) {
                return (FamilyTree<Human>) object;
            } else {
                throw new IllegalArgumentException("Invalid object type");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}