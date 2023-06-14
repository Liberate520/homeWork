package HW;

import HW.model.dog.Dog;
import HW.model.human.Human;
import HW.model.dataManager.DataSaver;
import HW.model.dataManager.UpDownLoader;
import HW.model.tree.FamilyTree;
import HW.view.ConsoleUI;

import java.io.IOException;
import java.time.LocalDate;

import static HW.model.human.enumerate.Sex.F;
import static HW.model.human.enumerate.Sex.M;


public class Main {
    /**
     * Реализовать, с учетом ооп подхода, приложение.
     * Для проведения исследований с генеалогическим древом.
     * Идея: описать некоторое количество компонент, например:
     * модель человека и дерева
     * Под “проведением исследования” можно понимать например получение всех детей выбранного человека.
     * <p>
     * Сделать PR к проекту: https://github.com/Liberate520/homeWork
     * В качестве ответа указать ссылку на PR
     * Ссылка на то как сделать пулреквест смотри в материалах к уроку
     * Если PR все таки не дается, то можно и ссылкой на гит репозиторий
     * <p>
     * <p>
     * Продолжаем работать с проектом с семейным деревом.
     * Реализовать интерфейс Iterable для дерева.
     * Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
     * <p>
     * Продолжаем грейдить наш проект с гениологическим древом. Изменить древо, сделать класс параметизированным
     * с зависимостью от интерфейса. Продумать класс общения с пользователем
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree<Human> tree = new FamilyTree<>();
        tree.addPerson(new Human("Василий", "Иванов", M, LocalDate.of(1966, 12, 1), LocalDate.of(2000, 11, 5)));
        tree.addPerson(new Human("Светлана", "Иванова", F, LocalDate.of(1967, 12, 1)));
        tree.addAsChild(new Human("Игорь", "Иванов", M, LocalDate.of(1989, 5, 5), tree.findPerson("Василий", "Иванов"), tree.findPerson("Светлана", "Иванова")));
        tree.addAsChild(new Human("Николай", "Иванов", M, LocalDate.of(1992, 6, 5), tree.findPerson("Василий", "Иванов"), tree.findPerson("Светлана", "Иванова")));
        tree.addAsChild(new Human("Ирина", "Иванова", F, LocalDate.of(2018, 7, 5), tree.findPerson("Игорь", "Иванов"), null));
        tree.addAsChild(new Human("Наталья", "Иванова", F, LocalDate.of(2018, 8, 5), tree.findPerson("Николай", "Иванов"), null));

//        System.out.println(tree.findPerson("Василий", "Иванов"));
//        System.out.println();
//        System.out.println(tree.findPerson("Василий", "Иванов").getChildren());

        UpDownLoader file = new DataSaver();
        tree.saver(file);
        FamilyTree newTree = FamilyTree.recovery(file);

//        tree.printHList();
//        System.out.println();
//
//        tree.sortByName();
//        tree.printHList();
//        System.out.println();
//
//        tree.sortByDateOfBirth();
//        tree.printHList();
//        System.out.println();
//
//        tree.sortByNameLength();
//        tree.printHList();


        FamilyTree<Dog> treeDog = new FamilyTree<>();
        treeDog.addPerson(new Dog("Бродяга", "Сноу", M, LocalDate.of(1985, 12, 1), LocalDate.of(2000, 11, 5)));
        treeDog.addPerson(new Dog("Леди", "Сноу", F, LocalDate.of(1986, 12, 1)));
        treeDog.addAsChild(new Dog("Бетховен", "Сноу", M, LocalDate.of(1998, 5, 5), treeDog.findPerson("Бродяга", "Сноу"), treeDog.findPerson("Леди", "Сноу")));
        treeDog.addAsChild(new Dog("Мухтар", "Сноу", M, LocalDate.of(2000, 6, 5), treeDog.findPerson("Бродяга", "Сноу"), treeDog.findPerson("Леди", "Сноу")));
        treeDog.addAsChild(new Dog("Лесси", "Сноу", F, LocalDate.of(2018, 7, 5), treeDog.findPerson("Бетховен", "Сноу"), null));
        treeDog.addAsChild(new Dog("Жучка", "Сноу", F, LocalDate.of(2018, 8, 5), treeDog.findPerson("Мухтар", "Сноу"), null));

//        System.out.println();
//        System.out.println(treeDog.findPerson("Бродяга", "Сноу"));
//        System.out.println();
//        System.out.println(treeDog.findPerson("Бродяга", "Сноу").getChildren());

//        UpDownLoader fileDog = new DataSaver();
//        treeDog.saver(fileDog);
//        FamilyTree newTreeDog = FamilyTree.recovery(fileDog);

        ConsoleUI consoleUI = new ConsoleUI(tree);
        consoleUI.start();
    }

}
