package ru.gb.person.comparators;

import ru.gb.person.Person;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
