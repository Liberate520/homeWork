package ru.home_work.cherevichenko_sergey;

import ru.home_work.cherevichenko_sergey.Writable;

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
    // Метод для чтения
    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("homeWork.out"));
         Object p = (Object) objectInputStream.readObject();
        System.out.println(p);

        objectInputStream.close();



    }
}
