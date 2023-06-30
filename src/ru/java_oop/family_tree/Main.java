package ru.java_oop.family_tree;

import ru.java_oop.family_tree.human.Gender;
import ru.java_oop.family_tree.human.Human;
import ru.java_oop.family_tree.family_tree.familyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int humanId = 0;

        familyTree fTree = new familyTree();

        Human parent1 = new Human(humanId++, "Parent1", "Family1", Gender.Male, LocalDate.parse("1000-01-01"));
        Human parent2 = new Human(humanId++, "Parent2", "Family1", Gender.Female, LocalDate.parse("1000-02-02"));

        Human child1 = new Human(humanId++, "Child1", "Family1", Gender.Male, LocalDate.parse("1020-03-03"), parent2, parent1);
        Human child2 = new Human(humanId++, "Child2", "Family1", Gender.Female, LocalDate.parse("1022-04-04"), parent2, parent1);

        parent1.addChild(child1);
        parent1.addChild(child2);

        parent2.setChildren(parent1.getChildren());

        System.out.println(parent1 + "\n");
        System.out.println(parent2 + "\n");
        System.out.println(child1 + "\n");
        System.out.println(child2 + "\n");
    }
}
