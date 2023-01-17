package metods;

import Homework_5.Designer_Human;
import Homework_5.Femily_Tree;

import java.util.List;

public class PrintMetods {
    Designer_Human designer_human;
    Femily_Tree femily_tree;
    /*
    Описание класса
    В этом классе реализован вызов методов print
     */

    /**
     * Метод вывода всех людей из списка
     */
    public void printDrevo(List<Designer_Human> humans) {
        System.out.println(humans);
    }


    /**
     * метод с лямда выражением forEach
     * короткая запись для перебора коллекции. через forEach можно добавлять значение всему списку
     */
    public void printTheTreeForEach() {
        femily_tree.forEach(Designer_Human -> System.out.println());
        femily_tree.forEach(System.out::println); //указатель на метод выше


    }

    /**
     * Печать древа
     */
    public void printFamilyTree(Femily_Tree humans) {
        for (Designer_Human HHE : humans) {
            System.out.println(HHE);
        }
        System.out.println();
    }

    /**
     * метод вывода всех людей из дерева
     */
    public void ShowALL(List<Designer_Human> humans) {
        for (Designer_Human human : designer_human.getHumans()) {
            System.out.println(human.toString());
        }
    }

}