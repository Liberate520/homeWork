import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Adding family members
        Person john = new Person("John", Gender.MALE, "1990-01-01");
        Person alice = new Person("Alice", Gender.FEMALE, "1992-05-15");
        Person mike = new Person("Mike", Gender.MALE, "1995-11-30");
        Person jenny = new Person("Jenny", Gender.FEMALE, "1998-08-20");
        Person susan = new Person("Susan", Gender.FEMALE, "1965-03-10");
        Person patrick = new Person("Patrick", Gender.MALE, "1962-07-25");

        // Creating relationships
        john.addChild(alice);
        john.addChild(mike);
        john.addChild(jenny);

        susan.addChild(alice);
        susan.addChild(mike);
        susan.addChild(jenny);

        patrick.addChild(alice);
        patrick.addChild(mike);
        patrick.addChild(jenny);

        familyTree.addPerson(john);
        familyTree.addPerson(alice);
        familyTree.addPerson(mike);
        familyTree.addPerson(jenny);
        familyTree.addPerson(susan);
        familyTree.addPerson(patrick);

        String selectedPerson = "John";
        List<Person> childrenOfSelectedPerson = familyTree.getChildrenOfPerson(selectedPerson);

        if (!childrenOfSelectedPerson.isEmpty()) {
            System.out.println("Children of " + selectedPerson + ":");
            for (Person child : childrenOfSelectedPerson) {
                System.out.println(child);
            }
        } else {
            System.out.println(selectedPerson + " does not have any children.");
        }

        FileHandler fileHandler = new FileHandler();
        try {
            fileHandler.writeToFile(familyTree.getPeople(), "family_tree.dat");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        List<Person> loadedPeople = new ArrayList<>();
        try {
            loadedPeople = fileHandler.readFromFile("family_tree.dat");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        // Printing the family tree
        System.out.println("\nLoaded Family Tree:");
        for (Person person : loadedPeople) {
            System.out.println(person);
        }
    }
}
