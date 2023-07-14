package FamilyTree;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();

        Human human1 = new Human("Ваилий", Gender.Male, 1958, null);
        Human human2 = new Human("Людмила", Gender.Female, 1958, null);
        Human human3 = new Human("Андрей", Gender.Male, 1993, human1, human2, null);

        Reader file = new Reader();
        file.save(tree);

        Tree tree2 = new Tree();
        tree2 = file.open();
        System.out.println(tree2.getInfo());
        System.out.println();

        System.out.println("People in the tree: ");
        for (Human human : tree) {
            System.out.println(human);
        }

    }
}