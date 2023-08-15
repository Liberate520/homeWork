package ru.geekbrains.family_tree.model.database;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileWriter implements Writer {
    
    /**
     * Путь к файлу.
     */
    String file;

    public FileWriter(String file) {
        this.file = file;
    }

    public FileWriter() {
        this(null);
    }

    /**
     * Записывает данные в файл или выводит информационное сообщение, если
     * произошла ошибка при работе с файлами.
     */
    @Override
    public void write(Object object) throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                                                new FileOutputStream(file));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }

}
