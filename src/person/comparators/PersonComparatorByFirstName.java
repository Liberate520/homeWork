package person.comparators;

import person.Person;

import java.util.Comparator;

public class PersonComparatorByFirstName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
