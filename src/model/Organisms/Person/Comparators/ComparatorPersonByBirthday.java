package model.Organisms.Person.Comparators;

import model.Organisms.Person.Person;

import java.util.Comparator;

public class ComparatorPersonByBirthday<T extends Person> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1.getBirthDate().isBefore(o2.getBirthDate())) {
            return -1;
        } else if (o1.getBirthDate().isAfter(o2.getBirthDate())) {
            return 1;
        }return 0;
    }
}
