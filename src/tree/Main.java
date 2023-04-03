package tree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import tree.familyTree.FamilyTree;
import tree.handlers.Input;
import tree.handlers.Output;
import tree.human.Gender;
import tree.human.Human;

/**
 * Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм
 * Реализовать, с учетом ооп подхода, приложение.
 * Для проведения исследований с генеалогическим древом.
 * Идея: описать некоторое количество компонент, например:
 * модель человека и дерева
 * Под “проведением исследования” можно понимать например получение всех детей
 * выбранного человека.
 * 
 * Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования
 * В проекте с гениалогическим древом подумайте и используйте интерфейсы.
 * Дополнить проект методами записи в файл и чтения из файла.
 * Для этого создать отдельный класс и реализовать в нем нужные методы.
 * Для данного класса сделайте интерфейс, который и используйте в своей
 * программе.
 * НАПРИМЕР в классе дерева в качестве аргумента метода save передавайте не
 * конкретный класс,
 * а объект интерфейса, с помощью которого и будет происходить запись.
 * Пример работы с интерфейсом Serialazable можно найти в материалах к уроку
 * https://habr.com/ru/post/431524/
 * 
 * ### Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования
 * Продолжаем работать с проектом с семейным деревом.
 * Реализовать интерфейс Iterable для дерева.
 * Создать методы сортировки списка людей перед выводом,
 * например по имени или по дате рождения (не менее 2)
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        FamilyTree tree = new FamilyTree();

        Human dad = new Human("Петр", "Осетров", Gender.Male, LocalDate.of(1986, 7, 21));
        Human mom = new Human("Лариса", "Осетрова", Gender.Female, LocalDate.of(1988, 2, 1));
        Human son = new Human("Дмитрий", "Осетров", Gender.Male, LocalDate.of(2000, 5, 4));
        Human dah = new Human("Олеся", "Осетрова", Gender.Female, LocalDate.of(2005, 11, 27));

        dad.addChild(son);
        dad.addChild(dah);
        mom.addChild(son);
        mom.addChild(dah);

        tree.addHuman(dad);
        tree.addHuman(mom);
        tree.addHuman(son);
        tree.addHuman(dah);

        Set<Human> children = tree.getChildren(mom);
        // System.out.println("мать: " + mom);
        // for (Human child : children) {
        // System.out.println("\tдети: " + child.getInfo());
        // }

        Set<Human> childList = tree.getChildren(dad);

        // for (Human child : childList) {
        // System.out.println(child.getInfo());
        // }

        Set<Human> descendants = tree.getDescendants(dad);

        // for (Human descendant : descendants) {
        // System.out.println(descendant.getInfo());
        // }

        Set<Human> relatives = tree.getRelatives(son);

        for (Human relative : relatives) {
            System.out.println(relative.getInfo());
        }

        Set<Human> searchResult = tree.searchByName("Петр");

        // for (Human human : searchResult) {
        // System.out.println(human.getInfo());
        // }

        Output output = new Output();
        output.printOut(tree);

        Input input = new Input();
        input.printIn();

    }
}
