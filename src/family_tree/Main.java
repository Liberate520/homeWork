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
        FamilyTree<Human> tree = new FamilyTree<>();
        FileHandler fileHandler = new FileHandler();

        Human ivanPetrov = new Human("Иван Петров", Sex.Male, LocalDate.of(1954, 10, 11));
        Human elizavetaKashina = new Human("Елизавета Кашина", Sex.Female, LocalDate.of(1959, 1, 19));

        tree.add(ivanPetrov);
        tree.add(elizavetaKashina);
        tree.add(new Human("Екатерина Мясникова", Sex.Female, LocalDate.of(1975, 12, 26),
                List.of(ivanPetrov, elizavetaKashina)));
        tree.add(new Human("Пётр Шишкин", Sex.Male, LocalDate.of(1981, 5, 21),
                List.of(ivanPetrov, elizavetaKashina)));

        System.out.println(tree.getInfo());

        tree.sortByBirthDate();
        System.out.println(tree.getInfo());

        tree.sortByName();
        System.out.println(tree.getInfo());

        fileHandler.save(tree, "src/family_tree/tree.out");

        // FileHandler fileHandler = new FileHandler();
        // FamilyTree<Human> tree = (FamilyTree<Human>) fileHandler.read("src/family_tree/tree.out");
        // System.out.println(tree.getInfo());
    }
}
