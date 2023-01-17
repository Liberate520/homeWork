package metods;

import Homework_5.Designer_Human;
import Homework_5.Femily_Tree;

import java.util.*;
import java.util.stream.Stream;

public class SortClass {
    /*
    *ОПИСАНИЕ КЛАССА
    * В этом классе реализованны методы сортировки
     */
    Femily_Tree femily_tree;
    public List<Designer_Human> designer_human;
    Scanner iScanner = new Scanner(System.in);


    public void sortingTheSheet() {
        System.out.println("""
                Выберите варианты сортировки
                1.По имени
                2.По дате рождения
                """);
        int choiceSort = iScanner.nextInt();
        try {
            switch (choiceSort) {
                case 1 -> {
                    sortByName();
                    sortLamdaByName();//сортировка с лямда выражением
                    sortByStreamByName();
                }
                case 2 -> {
                    sortByDateOfBirth();
                    sortByStreamByDate();
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Промазал давай по новой ");

        }

    }


    /**
     * Метод сортировки
     */
    @Deprecated
    public void sortBase() {
        Collections.sort(designer_human);
    }

    /**
     * Сортировка по имени
     */
    public void sortByName() {
        this.designer_human.sort(Comparator.comparing(Designer_Human::getName));
    }

    /**
     * Сортировка по дате
     */
    public void sortByDateOfBirth() {
        this.designer_human.sort(Comparator.comparing(Designer_Human::getDate));
    }

    /**
     * 1.сортировка с лямда выражением
     * 2.указатель на метод
     */
    public void sortLamdaByName() {
        Collections.sort(designer_human, ((o1, o2) -> o1.getName().compareTo((o2.getName()))));
        designer_human.sort((Comparator.comparing(Designer_Human::getName))); //указатель на метод
    }
/*
через Stream интерфейс можем делать разную сортировку
 */

    /**
     * Stream интерфейс для сортировки
     * Получаем вывод типа boolean true/false
     * С выводом на экран, таким образом можно делать любую сортировку
     */
    public void sortByStreamByName() {
        Stream<Designer_Human> stream = designer_human.stream();
        stream.filter(humans -> Boolean.parseBoolean(humans.getName()));
        femily_tree.printTheTreeForEach();

    }

    /**
     * сортировка по дате через интерфейс stream
     * вызываем сортировку и сразу ее печатаем
     */
    public void sortByStreamByDate() {
        designer_human.stream().sorted(Comparator.comparing(Designer_Human::getDate)).
                forEach(System.out::println);
    }
}

