package io;

import java.io.*;

public class FileHandlerSaver<T> implements DataSave<T> {
    private void saveSer(T t) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.ser"));
        objectOutputStream.writeObject(t);
        objectOutputStream.close();
    }


    @Override
            public void saveData(T t) throws IOException, ClassNotFoundException{
            saveSer(t);
            System.out.println("Файл сериализации создан");
    }

}



