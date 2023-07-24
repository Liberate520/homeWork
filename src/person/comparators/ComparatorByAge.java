package person.comparators;

import person.Person;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person one, Person two) {
        return one.getDateBirth().compareTo(two.getDateBirth());
    }
}
