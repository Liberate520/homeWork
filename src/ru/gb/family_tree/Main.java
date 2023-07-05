package ru.gb.family_tree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание объектов Person
        Person person1 = new Person("John", "Doe", 1980, Gender.MALE);
        Person person2 = new Person("Jane", "Doe", 1982, Gender.FEMALE);
        Person person3 = new Person("Alice", "Doe", 2005, Gender.FEMALE);
        Person person4 = new Person("Bob", "Doe", 2008, Gender.MALE);

        // Создание генеалогического дерева
        FamilyTree familyTree = new FamilyTree(person1);

        // Добавление детей
        person1.addChild(person3);
        person1.addChild(person4);

        person2.addChild(person3);
        person2.addChild(person4);

        // Получение детей выбранного человека
        List<Person> children = person1.getChildren();
        System.out.println("Children of " + familyTree.getRoot().getName() + ":");
        for (Person child : children) {
            System.out.println(child.getName());
        }
    }
}
