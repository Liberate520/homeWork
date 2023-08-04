import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Adding family members
        Person john = new Person("John", "Male", "1990-01-01");
        Person alice = new Person("Alice", "Female", "1992-05-15");
        Person mike = new Person("Mike", "Male", "1995-11-30");
        Person jenny = new Person("Jenny", "Female", "1998-08-20");
        Person susan = new Person("Susan", "Female", "1965-03-10");
        Person patrick = new Person("Patrick", "Male", "1962-07-25");

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

        // Printing the family tree
        System.out.println("\nFamily Tree:");
        familyTree.printFamilyTree(john, 0);
    }
}
