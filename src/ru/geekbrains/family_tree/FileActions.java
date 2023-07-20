package ru.geekbrains.family_tree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileActions implements ReadableAndWriteable {

    String file;

    public FileActions(String file) {
        this.file = file;
    }

    public FileActions() {
        this(null);
    }
    
    @Override
    public Object read() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                                                  new FileInputStream(file));
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Exception exception) {
            System.out.println("Произошла ошибка при работе с файлами.");
            return null;
        }
    }
    
    @Override
    public void write(Object object) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                                                    new FileOutputStream(file));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (Exception exception) {
            System.out.println("Произошла ошибка при работе с файлами.");
        }
    }

}
