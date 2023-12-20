package ru.gb.family_tree;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //FamilyTree tree = load();
        FamilyTree tree = testTree();
        System.out.println(tree);

        System.out.println(tree);

        // save(tree);
    }


    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human ruslan = new Human("Руслан", Gender.Male, LocalDate.of(1991, 3, 27));
        Human ludmila = new Human("Людмила", Gender.Female, LocalDate.of(1989, 8, 13));
        tree.add(ruslan);
        tree.add(ludmila);
        Human milana = new Human("Милана", Gender.Female, LocalDate.of(2018, 10, 29),
                ludmila, ruslan);
        tree.add(milana);
        Human grandFather = new Human("Иван", Gender.Male, LocalDate.of(1963, 1, 15));
        grandFather.addChild(ruslan);
        tree.add(grandFather);
        return tree;

    }
}

