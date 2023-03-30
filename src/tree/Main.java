package tree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        FamilyTree tree = new FamilyTree();
        // вот здесь вопрос с New Date
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

        List<Human> children = tree.getChildren(mom);
        // System.out.println("мать: " + mom);
        // for (Human child : children) {
        // System.out.println("\tдети: " + child.toString());
        // }

        List<Human> childList = tree.getChildren(dad);

        // for (Human child : childList) {
        // System.out.println(child.toString());
        // }

        List<Human> descendants = tree.getDescendants(dad);

        // for (Human descendant : descendants) {
        // System.out.println(descendant.toString());
        // }

        List<Human> relatives = tree.getRelatives(son);

        // for (Human relative : relatives) {
        // System.out.println(relative.toString());
        // }

        List<Human> searchResult = tree.searchByName("Петр");

        // for (Human human : searchResult) {
        // System.out.println(human.toString());
        // }

        Output output = new Output();
        output.printOut(tree);

        Input input = new Input();
        input.printIn();

    }
}
