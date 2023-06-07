package ru.gb.java;

import java.io.*;
import java.util.List;

public class SaveLoad implements Serialization {

    private String relativePath = "data/save.out";
    private File file = new File(relativePath);

    @Override
    public void save(List<Person> personList, Tree tree) throws IOException {

        file.getParentFile().mkdirs();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(personList);
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
        System.out.println("Сохранение завершено.");
    }

    @Override
    public void load() throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        List<Person> personList = (List<Person>) objectInputStream.readObject();
        Tree tree = (Tree) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Загрузка завершена.");
    }
}
