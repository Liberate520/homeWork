package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.file_handler;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.FamilyTree;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Human;

import java.io.*;

// Класс для записи в файл и чтения из файла
public class FileHandler implements Writable {
    private Object o;

    public FileHandler(Object o) {
        this.o = o;
    }

    // Метод для записи
    @Override
    public void save() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("tree.out"));
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("Не удалось Сохранить!");
        }

    }

    @Override
    // Метод для чтения
    public Object readable() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("tree.out"));
            Object o = objectInputStream.readObject();

            objectInputStream.close();
            return o;

        } catch (Exception e) {
            System.out.println("Не удалось восстановить!");
            return null;

        }

    }
}
