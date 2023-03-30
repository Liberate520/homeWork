package oop_1;

import java.io.*;

public class SaveLoad implements LoadFrom, SaveAs {

    // Загрузка данных из файла
    @Override
    public Serializable load(String path) {
        Serializable personRestored = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path))) {
            personRestored = (Serializable) objectInputStream.readObject();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return personRestored;
    }

    // Сохранение данных в файл
    @Override
    public void save(String path, Serializable obj) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path))) {
            objectOutputStream.writeObject(obj);
            System.out.println("Запись в файл произведена!");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}