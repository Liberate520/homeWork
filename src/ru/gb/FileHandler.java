package ru.gb;

import java.io.*;

public class FileHandler implements Writable {

    public void saveToFile(String fileName, Object object) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(object);
            System.out.println("Объект записан в файл.");
        }
    }

    public Object readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object object = objectInputStream.readObject();
            System.out.println("Объект успешно загружен из файла.");
            return object;
        }
    }
}
