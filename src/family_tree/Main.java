package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Human;
import family_tree.human.Sex;
import family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FamilyTree tree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();

        tree.add(new Human("Иван Петров", Sex.Male, LocalDate.of(1954, 10, 11)));
        tree.add(new Human("Елизавета Кашина", Sex.Female, LocalDate.of(1959, 1, 19)));
        tree.add(new Human("Екатерина Мясникова", Sex.Female, LocalDate.of(1975, 12, 26),
            List.of(tree.getByName("Иван Петров"),tree.getByName("Елизавета Кашина"))));
        tree.add(new Human("Пётр Шишкин", Sex.Male, LocalDate.of(1981,05,21),
                List.of(tree.getByName("Иван Петров"),tree.getByName("Елизавета Кашина"))));


        System.out.println(tree.getInfo());

        tree.sortByBirthDate();
        System.out.println(tree.getInfo());
        tree.sortByName();
        System.out.println(tree.getInfo());

        fileHandler.save(tree, "src/family_tree/tree.out");

//        FileHandler fileHandler = new FileHandler();
//        FamilyTree tree = (FamilyTree) fileHandler.read("src/family_tree/tree.out");
//        System.out.println(tree.getInfo());
    }

}
