package Homeworks.Family_tree;

import java.util.*;

import Homeworks.Family_tree.Applications.FileProcessing;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗадание к уроку 1:________________________________\n");

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
            System.out.println(child.getName() + "\n"); // Alice
        }
        System.out.println(familyTree); // сделал переопределения метода toString в классах

        System.out.println("\nЗадание к уроку 2:________________________________\n");

        // Создание пути или обращение к уже созанному файлу
        String filePath = "src/Homeworks/family_tree/Files/familyTree.out";

        // Создали конструкто класса, который implements интерфейсы WritingFile,
        // ReadingFile
        FileProcessing fileProcessing = new FileProcessing();

        // Сохранение и создания файла с помощью методов интерфейсов и серилизации
        fileProcessing.createSaveWriteFile(familyTree, filePath); // запись и сохранение файла, создание
        System.out.println(familyTree + "\n");

        // FileProcessing fileProcessing = new FileProcessing();

        // Чтение файла
        familyTree = (FamilyTree) fileProcessing.readFile(filePath);
        System.out.println(familyTree + "\n");
    }

}