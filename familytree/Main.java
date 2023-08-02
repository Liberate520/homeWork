package homeWork.familytree;

import java.time.LocalDate;
import java.util.List;
import homeWork.familytree.Gender;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        // Adding members to the family tree
        Human john = new Human("John Doe", LocalDate.of(1980, 5, 15), Human.Gender.MALE);
        Human jane = new Human("Jane Doe", LocalDate.of(1982, 8, 23), Human.Gender.FEMALE);
        Human child1 = new Human("Child 1", LocalDate.of(2005, 4, 10), Human.Gender.MALE);
        Human child2 = new Human("Child 2", LocalDate.of(2008, 9, 17), Human.Gender.FEMALE);

        john.addChild(child1);
        jane.addChild(child1);
        john.addChild(child2);
        jane.addChild(child2);

        tree.addMember(john);
        tree.addMember(jane);

        // Displaying the sorted list of people by name
        System.out.println("Sorted by name:");
        for (Human human : tree.sortByName()) {
            System.out.println(human);
        }

        // Displaying the sorted list of people by date of birth
        System.out.println("\nSorted by date of birth:");
        for (Human human : tree.sortByDateOfBirth()) {
            System.out.println(human);
        }

        // File handling
        FileHandler fileHandler = new FamilyTreeFileHandler();
        try {
            fileHandler.writeToFile(tree.getAllMembers(), "family_tree_data.txt");
            tree = new Tree();
            tree.addMember(john);

            List<Human> restoredHumans = fileHandler.readFromFile("family_tree_data.txt");
            System.out.println("\nRestored family tree data:");
            for (Human human : restoredHumans) {
                System.out.println(human);
            }
        } catch (IOException e) {
            System.err.println("Error in file handling: " + e.getMessage());
        }
    }
}
