package ru.gb.family_tree;

import ru.gb.family_tree.humans.Gender;
import ru.gb.family_tree.humans.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }
        static FamilyTree testTree() {
            FamilyTree tree = new FamilyTree();

            Human egor = new Human("Egor", Gender.Male, LocalDate.of(1990, 6, 15));
            Human valeria = new Human("Valeria", Gender.Female, LocalDate.of(1992, 7, 3));
            Human anna = new Human("Anna", Gender.Female, LocalDate.of(1973, 5, 6));
            Human denis = new Human("Denis", Gender.Male, LocalDate.of(1980, 10, 9));
            tree.addHumans(egor);
            tree.addHumans(valeria);
            tree.addHumans(anna);
            tree.addHumans(denis);

            Human ivan = new Human("Ivan", Gender.Male, LocalDate.of(1965, 12, 1), egor, valeria);
            Human ksenia = new Human("Ksenia", Gender.Female, LocalDate.of(1986, 5, 6), denis, anna);
            ivan.setDeathDate(LocalDate.of(2000, 1, 1));
            tree.addHumans(ivan);
            tree.addHumans(ksenia);

            Human grandMother = new Human("Natalya", Gender.Female, LocalDate.of(1970, 4, 6));
            grandMother.addChild(egor);
            tree.addHumans(grandMother);

            return tree;
        }
}

