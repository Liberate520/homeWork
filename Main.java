package homeWork;

public class Main {
        public static void main(String[] args) {
            Tree tree = new Tree();

            // Adding members to the family tree
            Human john = new Human("John", 35);
            Human mary = new Human("Mary", 32);
            Human alice = new Human("Alice", 10);
            Human bob = new Human("Bob", 8);
            Human chris = new Human("Chris", 5);

            john.addChild(alice);
            john.addChild(bob);
            john.addChild(chris);
            mary.addChild(alice);
            mary.addChild(bob);
            mary.addChild(chris);

            tree.addMember(john);
            tree.addMember(mary);

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
        }
    }

}
