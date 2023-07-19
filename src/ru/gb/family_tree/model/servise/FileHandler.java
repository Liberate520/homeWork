package ru.gb.family_tree.model.servise;

import java.io.*;

public class FileHandler implements SaveLoading {
    /**
     * Сериализация в файл с помощью класса ObjectOutputStream
     */
    @Override
    public Object save(Serializable serializable, String path) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Востановление из файла с помощью класса ObjectInputStream
     */
    @Override
    public Object loading(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream( new FileInputStream(path))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}