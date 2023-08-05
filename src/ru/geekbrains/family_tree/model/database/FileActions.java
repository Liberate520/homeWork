package ru.geekbrains.family_tree.model.database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Чтение и запись данных в файл.
 */
public class FileActions implements ReadableAndWriteable {

    /**
     * Путь к файлу.
     */
    String file;

    public FileActions(String file) {
        this.file = file;
    }

    public FileActions() {
        this(null);
    }
    
    /**
     * Возвращает прочитанные из файла данные или выводит информационное
     * сообщение, если произошла ошибка при работе с файлами.
     */
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
    
    /**
     * Записывает данные в файл или выводит информационное сообщение, если
     * произошла ошибка при работе с файлами.
     */
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
