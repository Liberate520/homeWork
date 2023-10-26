package homeWork3.core.models;

import homeWork3.core.mvp.Presenter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileStream implements LoadFrom, SaveAs {

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

    public void newHumanAdded(String name, String gender, int age, Presenter presenter) {
        presenter.familyConnect.addFamilyTree(new Human(name, gender, age));
        presenter.view.print("Новый человек добавлен в семью");
    }
}