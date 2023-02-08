package Old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Service {



//    Femily_Tree femily_tree = new Femily_Tree();//Экземпляр класса

//    private Service() {
//        this.humans = new ArrayList<>();
//    }

//    public List<Designer_Human> humans;

//    public Service(List<Designer_Human> humans) {
//        this.humans = humans;
//    }

//    private List<Designer_Human> humanList;

//
//    public Service(Femily_Tree humans) {
//        super();
////        this.humanList = new ArrayList<>();
//        this.humans = new ArrayList<>();
//    }
////
//    private static int id;
//
//    /**
//     * Перенес в femely_Tree
//     */
//    @Deprecated //метод устарел
//    public void addHumansId(String name, String sex, int date) {
//        Designer_Human humanList = new Designer_Human(id++, name, sex, date);
//        Designer_Human.addHumanSimpleMetod(humanList);
//
//    }
//
//    /**
//     * Метод сортировки
//     */
//    @Deprecated
//    public void sortBase() {
//        Collections.sort(humans);
//    }

//    /**
//     * Сортировка по имени
//     */
//    public void sortByName() {
//        this.humans.sort(Comparator.comparing(Designer_Human::getName));
//    }

//    /**
//     * Сортировка по дате
//     */
//    public void sortByDateOfBirth() {
//        this.humans.sort(Comparator.comparing(Designer_Human::getDate));
//    }

//    /**
//     * 1.сортировка с лямда выражением
//     * 2.указатель на метод
//     */
//    public void sortLamdaByName() {
//        Collections.sort(humans, ((o1, o2) -> o1.getName().compareTo((o2.getName()))));
//        humans.sort((Comparator.comparing(Designer_Human::getName))); //указатель на метод
//    }
///*
//через Stream интерфейс можем делать разную сортировку
// */

//    /**
//     * Stream интерфейс для сортировки
//     * Получаем вывод типа boolean true/false
//     * С выводом на экран, таким образом можно делать любую сортировку
//     */
//    public void sortByStreamByName() {
//        Stream<Designer_Human> stream = humans.stream();
//        stream.filter(humans -> Boolean.parseBoolean(humans.getName()));
//        femily_tree.printTheTreeForEach();
//
//    }

//    /**
//     * сортировка по дате через интерфейс stream
//     * вызываем сортировку и сразу ее печатаем
//     */
//    public void sortByStreamByDate() {
//        humans.stream().sorted(Comparator.comparing(Designer_Human::getDate)).
//                forEach(System.out::println);
//    }
}
