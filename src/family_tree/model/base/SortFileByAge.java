package family_tree.model.base;

import family_tree.model.human.Human;
import family_tree.model.tree.FamilyTree;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
public class SortFileByAge {
    static ArrayList<Human> humans = new ArrayList<>();
    public static void sortByAgeForTree() {
        String filePath = "homeWork/src/model_app/family_tree_.txt";
        // выводим на экран
        Object humAge;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Десериализуем объекты
//            System.out.println("\n============= Сортировка списка по Возрасту : ");
            while (true) {
                try {
                    humAge = (Human) objectInputStream.readObject();
                    //Сортировка списка по Доходам
                    humans.sort(Comparator.comparing(Human::getAge).reversed());
                    System.out.println(humAge);

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
