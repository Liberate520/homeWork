package person.comparators;

import person.Person;

import java.util.Comparator;

public class PersonComparatorByNameASC<E extends Person> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getPersonName().compareTo(o2.getPersonName());
    }
}
