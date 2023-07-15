package ru.java_oop.family_tree;

import ru.java_oop.family_tree.model.service.Service;
import ru.java_oop.family_tree.model.file_handler.FileHandler;
import ru.java_oop.family_tree.model.human.Gender;
import ru.java_oop.family_tree.model.human.Human;
import ru.java_oop.family_tree.model.family_tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


//      SAVE BLOCK
        FamilyTree<?> familyTree = new FamilyTree<>();
        Service service1 = new Service(familyTree);

        createObjectsForFamilyTree(familyTree, service1);

        performFamilyTreeSaveToFile(familyTree);

//      LOAD BLOCK
        FamilyTree<?> familyTreeLoaded = loadFamilyTreeFromFile();
        Service service2 = new Service(familyTreeLoaded);

        System.out.println(service1.getFamilyTreeInfo() + "\nLoaded tree from file:");
        System.out.println(service2.getFamilyTreeInfo());

        service2.sortByName();
        System.out.println("\n\nSorted by name:\n" + service2.getFamilyTreeInfo());

        service2.sortByAge();
        System.out.println("\n\nSorted by age:\n" + service2.getFamilyTreeInfo());

    }

    public static void performFamilyTreeSaveToFile(FamilyTree<?> familyTree) {
        FileHandler fh = new FileHandler("src/ru/java_oop/backup.out");
        fh.writeObjToFile(familyTree);
    }

    public static FamilyTree<?> loadFamilyTreeFromFile() {

        FileHandler fh = new FileHandler("src/ru/java_oop/backup.out");
        return (FamilyTree<?>) fh.readObjFromFile();
    }

    public static void createObjectsForFamilyTree(FamilyTree<?> familyTree, Service service) {
        Human parent1 = service.addFamilyMember("C_Parent17", Gender.Male, LocalDate.parse("1965-01-01"));
        Human parent2 = service.addFamilyMember("A_Parent2", Gender.Female, LocalDate.parse("1970-02-02"));

        Human child1 = service.addFamilyMember("D_Child13", Gender.Male, LocalDate.parse("1987-03-03"), parent2, parent1);
        Human child2 = service.addFamilyMember("B_Child2", Gender.Female, LocalDate.parse("1989-04-04"), parent2, parent1);

        service.setWedding(parent1.getId(), parent2.getId());
    }
}
