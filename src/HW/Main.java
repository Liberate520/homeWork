package HW;

import HW.Human.Human;
import HW.Service.DataSaver;
import HW.Service.UpDownLoader;
import HW.Tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;

import static HW.Human.Enum.Sex.F;
import static HW.Human.Enum.Sex.M;


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
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FamilyTree tree = new FamilyTree();
        tree.addPerson(new Human("Василий", "Иванов", M, LocalDate.of(1966, 12, 1), LocalDate.of(2000, 11, 5)));
        tree.addPerson(new Human("Светлана", "Иванова", F, LocalDate.of(1967, 12, 1)));
        tree.addAsChild(new Human("Игорь", "Иванов", M, LocalDate.of(1989, 5, 5), tree.findPerson("Василий", "Иванов"), tree.findPerson("Светлана", "Иванова")));
        tree.addAsChild(new Human("Николай", "Иванов", M, LocalDate.of(1992, 6, 5), tree.findPerson("Василий", "Иванов"), tree.findPerson("Светлана", "Иванова")));
        tree.addAsChild(new Human("Ирина", "Иванова", F, LocalDate.of(2018, 7, 5), tree.findPerson("Игорь", "Иванов"), null));
        tree.addAsChild(new Human("Наталья", "Иванова", F, LocalDate.of(2018, 8, 5), tree.findPerson("Николай", "Иванов"), null));

        System.out.println(tree.findPerson("Василий", "Иванов"));
        System.out.println();
        System.out.println(tree.findPerson("Василий", "Иванов").getChildren());

        UpDownLoader file = new DataSaver();
        tree.saver(file);
        FamilyTree newTree = FamilyTree.recovery(file);

        tree.PrintHList();
        System.out.println();

        tree.SortByName();
        tree.PrintHList();
        System.out.println();

        tree.SortByDateOfBirth();
        tree.PrintHList();
        System.out.println();

        tree.SortByNameLength();
        tree.PrintHList();
    }
}
