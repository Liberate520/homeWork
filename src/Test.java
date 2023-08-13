import FamilyTree.Tree;
import Human.Gender;
import Human.Person;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Tree tree = testTree();
        System.out.println(tree);
    }

    static Tree testTree() {
        Tree tree = new Tree();

        Person james = new Person("James Jons", Gender.Male, LocalDate.of(1957, 6, 20));
        Person july = new Person("July Jons", Gender.Female, LocalDate.of(1956, 7, 21));
        tree.add(james);
        tree.add(july);
        tree.setWedding(james, july);

        Person jana = new Person("Jana Alley", Gender.Female, LocalDate.of(1975, 12, 7), james, july);
        Person hope = new Person("Hope Jons", Gender.Female, LocalDate.of(1988, 1, 5), james, july);
        tree.add(jana);
        tree.add(hope);

        Person aleks = new Person("Aleks Alley", Gender.Male, LocalDate.of(1965, 9, 20));
        tree.add(aleks);
        tree.setWedding(aleks, jana);

        Person katerine = new Person("Katerina Jons", Gender.Female, LocalDate.of(1945, 12, 7));
        katerine.addChild(james);
        tree.add(katerine);

        return tree;
    }
}
