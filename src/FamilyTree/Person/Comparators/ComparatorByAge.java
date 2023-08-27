package family_tree.FamilyTree.Person.Comparators;

import family_tree.FamilyTree.Person.Person;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o2.getDataBirth().compareTo(o1.getDataBirth());
    }
}
