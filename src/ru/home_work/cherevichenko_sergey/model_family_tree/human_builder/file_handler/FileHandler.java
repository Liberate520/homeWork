package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.file_handler;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.FamilyTree;
import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Human;

import java.io.*;
// Класс для записи в файл и чтения из файла
public class FileHandler implements Writable {
// Метод для записи
    @Override
    public void save(Object o) throws IOException {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("tree.out"));
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
    }
    @Override
    // Метод для чтения
    public Object readable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("tree.out"));
         Object o = objectInputStream.readObject();
         objectInputStream.close();
       return o;
    }
}
