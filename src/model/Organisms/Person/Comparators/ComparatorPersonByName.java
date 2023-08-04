package model.Organisms.Person.Comparators;

import model.Organisms.Person.Person;

import java.util.Comparator;

public class ComparatorPersonByName<T extends Person> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
