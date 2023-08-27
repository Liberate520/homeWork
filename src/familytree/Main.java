package familytree;

import familytree.FamilyTree;
import familytree.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree<TreeEntity> familyTree = new FamilyTree<>();

        TreeEntity john = new TreeEntity("John", "1990-01-01");
        TreeEntity alice = new TreeEntity("Alice", "1992-05-15");
        TreeEntity mike = new TreeEntity("Mike", "1995-11-30");
        TreeEntity jenny = new TreeEntity("Jenny", "1998-08-20");
        TreeEntity susan = new TreeEntity("Susan", "1965-03-10");
        TreeEntity patrick = new TreeEntity("Patrick", "1962-07-25");

        familyTree.addEntity(john);
        familyTree.addEntity(alice);
        familyTree.addEntity(mike);
        familyTree.addEntity(jenny);
        familyTree.addEntity(susan);
        familyTree.addEntity(patrick);

        String selectedEntity = "John";
        List<TreeEntity> childrenOfSelectedEntity = familyTree.getEntitiesByName(selectedEntity);

        if (!childrenOfSelectedEntity.isEmpty()) {
            System.out.println("Children of " + selectedEntity + ":");
            for (TreeEntity child : childrenOfSelectedEntity) {
                System.out.println(child);
            }
        } else {
            System.out.println(selectedEntity + " does not have any children.");
        }

        FileHandler fileHandler = new FileHandler();
        try {
            fileHandler.writeToFile(familyTree.getEntities(), "family_tree.dat");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        List<Person> loadedEntities = new ArrayList<>();
        try {
            loadedEntities = fileHandler.readFromFile("family_tree.dat");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        // Printing the loaded entities
        System.out.println("\nLoaded Family Tree:");
        for (Person entity : loadedEntities) {
            System.out.println(entity);
        }
    }
}
