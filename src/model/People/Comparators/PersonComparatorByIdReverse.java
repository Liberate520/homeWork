package model.People.Comparators;

import model.People.Person;

import java.util.Comparator;

public class PersonComparatorByIdReverse implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return -1 * Integer.compare(o2.getId(), o1.getId());
    }
}
