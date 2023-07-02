package family_tree;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Иван Петров", Sex.Male, LocalDate.of(1954, 10, 11)));
        tree.add(new Human("Елизавета Кашина", Sex.Female, LocalDate.of(1959, 1, 19)));
        tree.add(new Human("Екатерина Мясникова", Sex.Female, LocalDate.of(1975, 12, 26),
            List.of(tree.getByName("Иван Петров"),tree.getByName("Елизавета Кашина"))));
        tree.add(new Human("Пётр Шишкин", Sex.Male, LocalDate.of(1981,05,21),
                List.of(tree.getByName("Иван Петров"),tree.getByName("Елизавета Кашина"))));


        System.out.println(tree.getInfo());
    }

}
