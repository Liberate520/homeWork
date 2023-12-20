package ru.gb.person.comparators;

import ru.gb.person.Person;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
