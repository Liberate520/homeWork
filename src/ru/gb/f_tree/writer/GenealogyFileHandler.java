package ru.gb.f_tree.writer;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenealogyFileHandler implements Writable {

    private static final Logger logger = Logger.getLogger(GenealogyFileHandler.class.getName());

    @Override
    public boolean write(Serializable serializable, String filepath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(serializable);
            logger.log(Level.INFO, "Данные успешно записаны в файл: " + filepath);
            return true;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка записи данных в файл: " + filepath, e);
            return false;
        }
    }

    @Override
    public Object read(String filepath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            Object object = ois.readObject();
            logger.log(Level.INFO, "Данные успешно причитаны из файла: " + filepath);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Ошибка чтения данных из файла: " + filepath, e);
            return null;
        }
    }
}