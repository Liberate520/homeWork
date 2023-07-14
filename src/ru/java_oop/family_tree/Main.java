package ru.java_oop.family_tree;

import ru.java_oop.family_tree.family_tree.FamilyTreeItem;
import ru.java_oop.family_tree.file_handler.FileHandler;
import ru.java_oop.family_tree.human.Gender;
import ru.java_oop.family_tree.human.Human;
import ru.java_oop.family_tree.family_tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//      SAVE BLOCK
        FamilyTree<Human> familyTree = new FamilyTree<>();
        createObjectsForFamilyTree(familyTree);

        performFamilyTreeSaveToFile(familyTree);

//      LOAD BLOCK
        FamilyTree<Human> familyTreeLoaded = loadFamilyTreeFromFile();

        System.out.println(familyTree + "\nLoaded tree from file:");
        System.out.println(familyTreeLoaded);

        familyTreeLoaded.sortByName();
        System.out.println("\n\nSorted by name:\n" + familyTreeLoaded);

        familyTreeLoaded.sortByAge();
        System.out.println("\n\nSorted by age:\n" + familyTreeLoaded);

    }

    public static void performFamilyTreeSaveToFile(FamilyTree<Human> familyTree) throws IOException {
        FileHandler fh = new FileHandler("src/ru/java_oop/backup.out");
        fh.writeObjToFile(familyTree);
    }

    public static FamilyTree<Human> loadFamilyTreeFromFile() throws IOException, ClassNotFoundException {

        FileHandler fh = new FileHandler("src/ru/java_oop/backup.out");
        return (FamilyTree<Human>) fh.readObjFromFile();
    }

    public static void createObjectsForFamilyTree(FamilyTree<Human> familyTree) {
        Human parent1 = new Human("C_Parent17", Gender.Male, LocalDate.parse("1965-01-01"));
        Human parent2 = new Human("A_Parent2", Gender.Female, LocalDate.parse("1970-02-02"));

        Human child1 = new Human("D_Child13", Gender.Male, LocalDate.parse("1987-03-03"), parent2, parent1);
        Human child2 = new Human("B_Child2", Gender.Female, LocalDate.parse("1989-04-04"), parent2, parent1);

        familyTree.addFamilyMember(parent1);
        familyTree.addFamilyMember(parent2);
        familyTree.addFamilyMember(child1);
        familyTree.addFamilyMember(child2);

        familyTree.setWedding(parent1.getId(), parent2.getId());
    }
}
