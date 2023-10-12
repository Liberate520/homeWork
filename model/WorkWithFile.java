package homeWork3.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class WorkWithFile implements LoadFrom, SaveAs {

    // Загрузка данных из файла
    @Override
    public Serializable load(String path) {
        Serializable personRestored = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path))) {
            personRestored = (Serializable) objectInputStream.readObject();
            System.out.println("Cемейное древо загружено");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

        return personRestored;
    }

    // Сохранение данных в файл
    @Override
    public void save(String path, Serializable object) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path))) {
            objectOutputStream.writeObject(object);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}