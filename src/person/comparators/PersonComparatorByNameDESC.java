package person.comparators;

import person.Person;

import java.util.Comparator;

public class PersonComparatorByNameDESC<E extends Person> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o2.getPersonName().compareTo(o1.getPersonName());
    }
}
