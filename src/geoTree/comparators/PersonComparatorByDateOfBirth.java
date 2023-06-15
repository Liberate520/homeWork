package geoTree.comparators;
import java.util.Comparator;

import person.Person;

public class PersonComparatorByDateOfBirth implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getDateOfBirth().getYear(), o2.getDateOfBirth().getYear());
    }
}
