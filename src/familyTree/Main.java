package familyTree;


import familyTree.familyTree.FamilyTree;
import familyTree.human.Gender;
import familyTree.human.Human;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

import static familyTree.writer.FileHandler.serialization;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException {
        FamilyTree<Human> tree = testTree();
        System.out.println("Without sort: " + tree);
        tree.sortByName();
        System.out.println("Sort by name: " + tree);
        tree.sortByAge();
        System.out.println("Sort by age (from lowest to highest): " + tree);

    }

    static FamilyTree<Human> testTree() throws IOException {
        FamilyTree<Human> tree = new FamilyTree();

        Human dinara = new Human("Динара",
                LocalDate.of(1998, 1, 31),
                Gender.Female);
        Human slava = new Human("Вячеслав",
                LocalDate.of(1995, 8, 14),
                Gender.Male);
        tree.add(dinara);
        tree.add(slava);
        tree.setWedding(dinara, slava);

        Human anastasia = new Human("Анастасия", Gender.Female,
                LocalDate.of(2019, 3, 15), dinara, slava);
        Human stas = new Human("Станислав", Gender.Male, LocalDate.of(2024, 5, 27),
                dinara, slava);
        tree.add(anastasia);
        tree.add(stas);

        dinara.addChild(anastasia);
        slava.addChild(stas);

        Human nadezda = new Human("Надежда", LocalDate.of(1962, 3, 8), Gender.Female);
        nadezda.addChild(dinara);
        tree.add(nadezda);

        serialization();
        return tree;
    }


}
