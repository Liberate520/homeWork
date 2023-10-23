import Tree.FamilyTree;
import Tree.Gender;
import Tree.Person;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Person person  = new Person("Ann", Gender.female);
        Person parent1 = new Person("Bet", Gender.female);
        Person parent2 = new Person("Bob", Gender.male);
        Person grandma = new Person("Mary", Gender.female);

        tree.addPerson(person);
        tree.addPerson(parent1);
        tree.addPerson(parent2);
        tree.addPerson(grandma);

        tree.setParent1(person,parent1);
        tree.setParent2(person,parent2);

        tree.setParent1(parent1,grandma);

        tree.printTree();
    }
}
