package metods;

import Homework_5.Femily_Tree;

import java.util.List;

import static metods.Designer_Human.humans;

/*
    Описание класса
    В этом классе реализован вызов методов print
     */

public class PrintMetods {

    /**
     * Метод вывода всех людей из списка
     */
    public void printDrevo(List<Designer_Human> humans) {
        System.out.println(humans);
    }

    /**
     * метод вывода всех людей из дерева
     */
    public void showALL(List<Designer_Human> humans) {
        for (Designer_Human human : Femily_Tree.getHumans()) {
            System.out.println(human.toString());
        }
    }

    /**
     * метод с лямда выражением forEach
     * короткая запись для перебора коллекции. через forEach можно добавлять значение всему списку
     */
    public void printTheTreeForEach() {
        humans.forEach(Designer_Human -> System.out.println());
        humans.forEach(System.out::println); //указатель на метод выше


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

}