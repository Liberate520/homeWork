package tree;

import java.util.Date;
import java.util.List;

/**
 * Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм
 * Реализовать, с учетом ооп подхода, приложение.
 * Для проведения исследований с генеалогическим древом.
 * Идея: описать некоторое количество компонент, например:
 * модель человека и дерева
 * Под “проведением исследования” можно понимать например получение всех детей
 * выбранного человека.
 */
public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Human dad = new Human("Петр", "Осетров", Gender.Male, new Date(1986, 7, 21));
        Human mom = new Human("Лариса", "Осетрова", Gender.Female, new Date(1988, 2, 1));
        Human son = new Human("Дмитрий", "Осетров", Gender.Male, new Date(2000, 5, 4));
        Human dah = new Human("Олеся", "Осетрова", Gender.Female, new Date(2005, 12, 27));

        dad.addChild(son);
        dad.addChild(dah);
        mom.addChild(son);
        mom.addChild(dah);

        tree.addHuman(dad);
        tree.addHuman(mom);
        tree.addHuman(son);
        tree.addHuman(dah);

        List<Human> children = tree.getChildren(mom);
        System.out.println("мать: " + mom);
        for (Human child : children) {
            System.out.println("\tдети: " + child.toString());
        }

        List<Human> childList = tree.getChildren(dad);

        for (Human child : childList) {
            System.out.println(child.toString());
        }

        List<Human> descendants = tree.getDescendants(dad);

        for (Human descendant : descendants) {
            System.out.println(descendant.toString());
        }

        List<Human> relatives = tree.getRelatives(son);

        for (Human relative : relatives) {
            System.out.println(relative.toString());
        }

        List<Human> searchResult = tree.searchByName("Петр");

        for (Human human : searchResult) {
            System.out.println(human.toString());
        }

    }
}
