package homeWork;

import homeWork.Human;
import homeWork.Tree;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        // Adding members to the family tree
        LocalDate johnDateOfBirth = LocalDate.of(1988, 5, 15);
        Human john = new Human("John", johnDateOfBirth, Human.Gender.MALE);

        LocalDate maryDateOfBirth = LocalDate.of(1990, 8, 25);
        Human mary = new Human("Mary", maryDateOfBirth, Human.Gender.FEMALE);

        LocalDate aliceDateOfBirth = LocalDate.of(2010, 2, 3);
        Human alice = new Human("Alice", aliceDateOfBirth, Human.Gender.FEMALE);

        LocalDate bobDateOfBirth = LocalDate.of(2012, 11, 20);
        Human bob = new Human("Bob", bobDateOfBirth, Human.Gender.MALE);

        LocalDate chrisDateOfBirth = LocalDate.of(2015, 9, 8);
        Human chris = new Human("Chris", chrisDateOfBirth, Human.Gender.MALE);

        tree.addMember(john);
        tree.addMember(mary);
        tree.addChildToParent("John", alice);
        tree.addChildToParent("John", bob);
        tree.addChildToParent("John", chris);
        tree.addChildToParent("Mary", alice);
        tree.addChildToParent("Mary", bob);
        tree.addChildToParent("Mary", chris);

        // Research: Finding all children of a selected person
        String selectedPerson = "John";
        List<Human> children = tree.findChildren(selectedPerson);

        if (children != null && !children.isEmpty()) {
            System.out.print("The children of " + selectedPerson + " are: ");
            for (Human child : children) {
                System.out.print(child.getName() + ", ");
            }
            System.out.println();
        } else {
            System.out.println(selectedPerson + " is not in the family tree.");
        }

        // File handling
        FileHandler fileHandler = new FamilyTreeFileHandler();
        fileHandler.writeToFile(tree.getAllMembers(), "family_tree_data.txt");
        List<Human> restoredHumans = fileHandler.readFromFile("family_tree_data.txt");
        System.out.println("Restored family tree data:");
        for (Human human : restoredHumans) {
            System.out.println("Name: " + human.getName() + ", Date of Birth: " + human.getDateOfBirth() + ", Gender: " + human.getGender());
        }
    }
}


