package Homeworks.Family_tree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание генеалогического древа
        FamilyTree familyTree = new FamilyTree();

        // Создание людей для добавления в генеалогическое древо
        Human person1 = new Human("John", Gender.MALE);
        Human person2 = new Human("Jane", Gender.FEMALE);
        Human person3 = new Human("Bob", Gender.MALE);
        Human person4 = new Human("Alice", Gender.FEMALE);

        // Добавление людей в генеалогическое древо
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);

        // Создание связей между людьми в генеалогическом древе
        familyTree.addParentChildRelationships(person1, person3);
        familyTree.addParentChildRelationships(person2, person3);
        familyTree.addParentChildRelationships(person3, person4);

        // Получение всех детей выбранного человека
        Human selectedPerson = person3;
        List<Human> children = familyTree.getChildren(selectedPerson);

        System.out.println("Children of " + selectedPerson.getName() + ":"); // Children of Bob:
        for (Human child : children) {
            System.out.println(child.getName()); // Alice
        }
    }
}