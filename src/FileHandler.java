

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable {

    @Override
    public void write(String filename, Serializable input) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(input);
            System.out.println("Объект успешно записан в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи объекта в файл: " + e.getMessage());
        }
    }

    @Override
    public Serializable read(String filename) {
        Serializable output = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            System.out.println("Объект успешно прочитан из файла: " + filename);
            output = (Serializable) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении объекта из файла: " + e.getMessage());
        }
        return output;

    }

}