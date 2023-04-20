package service.Persons.Comparators;

import java.util.Comparator;


import service.Persons.Person;

public class NameComparator<T extends Person> implements Comparator<T> {
    @Override
    public int compare(Person member1, Person member2) {
        if (member1 != null && member2 != null) {
            return member1.getName().compareTo(member2.getName());
        }
        return 1;
    }
}

