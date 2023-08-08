package FamilyTree.Tree.model.FileHander;

import FamilyTree.Tree.model.FileHander.Writable;

import java.io.*;

public class readSave implements Writable {
    @Override
    public void save(Serializable serializable, String filePath) {

    }

    @Override
    public Serializable read(String path) {
        Serializable personRestored = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path))) {
            personRestored = (Serializable) objectInputStream.readObject();
            System.out.println("Загрузка данных: успех !\nВаше семейное древо загружено !");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return personRestored;
    }

    // Сохранение данных в файл
    @Override
    public void save(String path, Serializable obj) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path))) {
            objectOutputStream.writeObject(obj);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}

