package ru.java_oop.family_tree;

import ru.java_oop.family_tree.human.Gender;
import ru.java_oop.family_tree.human.Human;
import ru.java_oop.family_tree.family_tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human parent1 = new Human("Parent1", Gender.Male, LocalDate.parse("1000-01-01"));
        Human parent2 = new Human("Parent2", Gender.Female, LocalDate.parse("1000-02-02"));

        Human child1 = new Human("Child1", Gender.Male, LocalDate.parse("1020-03-03"), parent2, parent1);
        Human child2 = new Human("Child2", Gender.Female, LocalDate.parse("1022-04-04"), parent2, parent1);

        familyTree.addFamilyMember(parent1);
        familyTree.addFamilyMember(parent2);
        familyTree.addFamilyMember(child1);
        familyTree.addFamilyMember(child2);

        familyTree.setWedding(parent1.getId(), parent2.getId());

        System.out.println(familyTree);
    }
}
