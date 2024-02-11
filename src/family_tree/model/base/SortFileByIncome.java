package family_tree.model.base;

import family_tree.model.human.Human;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
public class SortFileByIncome {
    public static ArrayList<Human> humans = new ArrayList<>();
    public static void sortByIncomeForTree() {
        String filePath = "homeWork/src/model_app/family_tree_.txt";
        // выводим на экран
        Object humInc;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Десериализуем объекты
//            System.out.println("\n============= Сортировка списка по Доходу (по убыванию) :");
            while (true) {
                try {
                    humInc = (Human) objectInputStream.readObject();
                    //Сортировка списка по Доходам
                    humans.sort(Comparator.comparing(Human::getIncome).reversed());
                    System.out.println(humInc);

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
