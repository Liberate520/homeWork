import FamilyTree.Tree;
import Human.Gender;
import Human.Person;

import java.io.IOException;
import java.time.LocalDate;


public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Tree tree = testTree();
        System.out.println("Before: \n" + tree);

        FileHandler fh = new FileHandler("person.out", tree);
        fh.saveFile();
        Tree tree2 = fh.loadFile();

        System.out.println("After: \n" + tree2);
    }

    static Tree testTree() throws IOException {
        Tree tree = new Tree();

        Person james = new Person("James Jonsy", Gender.Male, LocalDate.of(1957, 6, 20));
        Person july = new Person("July Jons", Gender.Female, LocalDate.of(1956, 7, 21));
        tree.add(james);
        tree.add(july);
        tree.setWedding(james, july);

        Person jana = new Person("Janan Alleyn", Gender.Female, LocalDate.of(1975, 12, 7), james, july);
        Person hope = new Person("Hope Jonsy", Gender.Female, LocalDate.of(1988, 1, 5), james, july);
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
