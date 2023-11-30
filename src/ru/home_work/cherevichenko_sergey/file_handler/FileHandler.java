package ru.home_work.cherevichenko_sergey.file_handler;
import java.io.*;
// Класс для записи в файл и чтения из файла
public class FileHandler implements Writable {
// Метод для записи
    @Override
    public void save(Object o) throws IOException {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("homeWork.out"));
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
    }
    @Override
    // Метод для чтения
    public Object readable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("homeWork.out"));
         Object p = (Object) objectInputStream.readObject();
        objectInputStream.close();
        return p;
    }
    // интерфейс, для того чтобы пользоваться классами записи и чтения
    // методы для записи и чтения
    public static interface Writable {
        void save(Object o) throws IOException;
            Object readable() throws IOException, ClassNotFoundException;
    }
}
