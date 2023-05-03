package model.person.comparators;

import model.person.Person;

import java.util.Comparator;

public class PersonComparatorByIdDESC<E extends Person> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return -1*Integer.compare(o1.getID(), o2.getID());
    }
}
