package ru.java_oop.family_tree;

import ru.java_oop.family_tree.model.family_tree.FamilyTreeItem;
import ru.java_oop.family_tree.model.service.Service;
import ru.java_oop.family_tree.model.file_handler.FileHandler;
import ru.java_oop.family_tree.model.human.Gender;
import ru.java_oop.family_tree.model.human.Human;
import ru.java_oop.family_tree.model.family_tree.FamilyTree;
import ru.java_oop.family_tree.view.ConsoleUI;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();


//      SAVE BLOCK
        Service service1 = new Service();
        createObjectsForFamilyTree(service1);
        performFamilyTreeSaveToFile(service1);

//      LOAD BLOCK
        Service service2 = new Service();
        service2.setFamilyTree(loadFamilyTreeFromFile());

        System.out.println(service1.getFamilyTreeInfo() + "\nLoaded tree from file:");
        System.out.println(service2.getFamilyTreeInfo());

        service2.sortByName();
        System.out.println("\n\nSorted by name:\n" + service2.getFamilyTreeInfo());

        service2.sortByAge();
        System.out.println("\n\nSorted by age:\n" + service2.getFamilyTreeInfo());

    }

    public static void performFamilyTreeSaveToFile(Service service) {
        FileHandler fh = new FileHandler("backup.out");
        fh.writeObjToFile(service.getFamilyTreeAsObject());
    }

    public static FamilyTree<?> loadFamilyTreeFromFile() {

        FileHandler fh = new FileHandler("backup.out");
        return (FamilyTree<?>) fh.readObjFromFile();
    }

    public static void createObjectsForFamilyTree(Service service) {
        Human parent1 = (Human) service.addHumanFamilyMember("C_Parent17", Gender.Male, LocalDate.parse("1965-01-01"));
        Human parent2 = (Human) service.addHumanFamilyMember("A_Parent2", Gender.Female, LocalDate.parse("1970-02-02"));

        Human child1 = (Human) service.addHumanFamilyMember("D_Child13", Gender.Male, LocalDate.parse("1987-03-03"), parent2, parent1);
        Human child2 = (Human) service.addHumanFamilyMember("B_Child2", Gender.Female, LocalDate.parse("1989-04-04"), parent2, parent1);

        service.setWedding(parent1.getId(), parent2.getId());
    }
}
