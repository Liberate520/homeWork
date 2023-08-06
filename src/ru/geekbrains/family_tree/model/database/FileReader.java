package ru.geekbrains.family_tree.model.database;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Чтение данных из файла.
 */
public class FileReader implements Reader {

    /**
     * Путь к файлу.
     */
    String file;

    public FileReader(String file) {
        this.file = file;
    }

    public FileReader() {
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

}
