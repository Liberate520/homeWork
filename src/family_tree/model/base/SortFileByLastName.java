package family_tree.model.base;

import family_tree.model.human.Human;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
public class SortFileByLastName {
    static ArrayList<Human> humans = new ArrayList<>();
    public static void sortByLastNameForTree() {
        String filePath = "homeWork/src/model_app/family_tree_.txt";
        // выводим на экран
        Object humNam;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Десериализуем объекты
            // System.out.println("\n============= Сортировка списка по Фамилии (по алфавиту) : ");
            while (true) {
                try {
                    humNam = (Human) objectInputStream.readObject();
                    //Сортировка списка по фамилии
                    humans.sort(Comparator.comparing(Human::getLastName).reversed());
                    System.out.println(humNam);

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
