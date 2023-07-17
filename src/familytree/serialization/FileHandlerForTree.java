package ru.gb.family_tree.familytree.serialization;

import java.io.*;



public class FileHandlerForTree implements Writable {
    @Override
    public boolean save( Serializable familyTree,String filePath) {
        //Сериализация в файл с помощью класса ObjectOutputStream
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(familyTree);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        @Override
        public Object read( String filePath) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
                return objectInputStream.readObject();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

    }
}

