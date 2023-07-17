package OopJava;

import OopJava.Human.Gender;
import OopJava.Human.Human;
import OopJava.Service.FileReader;
import OopJava.Service.Service;
import OopJava.Tree.FamilyTree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        Service service = new Service(tree);

        Human human1 = new Human("Petr", Gender.Male, 1960);
        Human human2 = new Human("Masha", Gender.Female, 1955);
        Human human3 = new Human("Elena", Gender.Female, 1995, human1, human2, null);
        Human human4 = new Human("Katya", Gender.Female, 1999, human1, human2, null);

        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);

        FileReader file = new FileReader();
        file.save(tree);

        System.out.println("Люди в дереве:");
        System.out.println(tree.getInfo());

        service.sortByName();
        System.out.println("Сортировка людей по имени: ");
        for (Object person : tree) {
            System.out.println(person);
        }

        service.sortByYear();
        System.out.println();
        System.out.println("Сортировка людей по возрасту: ");
        for (Object person : tree) {
            System.out.println(person);
        }

    }
}
