package person.comparators;

import person.Person;

import java.util.Comparator;

public class PersonComparatorByLastName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
