package model.comparate;

import model.Person;

import java.util.Comparator;

public class PersonComparatorYear<T extends Person> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getYear(), o2.getYear());
    }
}