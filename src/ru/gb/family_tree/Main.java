package ru.gb.family_tree;

import ru.gb.family_tree.person.Gender;
import ru.gb.family_tree.person.Person;
import ru.gb.family_tree.tree.FamilyTree;


public class Main {
    public static void main(String[] args) {
        Person grandparent = new Person("Grandparent", Gender.Male);
        Person parent1 = new Person("Parent 1", Gender.Male);
        Person parent2 = new Person("Parent 2", Gender.Female);
        Person child1 = new Person("Child 1", Gender.Female);
        Person child2 = new Person("Child 2", Gender.Male);
        Person child3 = new Person("Child 3", Gender.Female);

        grandparent.addChild(parent1);

        parent1.addChild(child1);
        child2.addParent(parent1);
        parent2.addChild(child3);

        // Получение детей выбранного человека
        FamilyTree grandparentTree = new FamilyTree(grandparent);
        System.out.println(grandparentTree);

        FamilyTree parent1Tree = new FamilyTree(parent1);
        System.out.println(parent1Tree);

        FamilyTree parent2Tree = new FamilyTree(parent2);
        System.out.println(parent2Tree);

        FamilyTree child1Tree = new FamilyTree(child1);
        System.out.println(child1Tree);
    }
}
