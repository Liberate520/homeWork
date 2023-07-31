package person.comparators;

import familyTree.TreeNode;
import person.Person;

import java.util.Comparator;

public class ComparatorByAge<Person extends TreeNode<Person>> implements Comparator<Person> {
    @Override
    public int compare(Person one, Person two) {
        return one.getDateBirth().compareTo(two.getDateBirth());
    }
}
