package service.Persons.Comparators;


import service.Persons.Person;

import java.util.Comparator;

public class DateComparator<T extends Person> implements Comparator<T>{
    @Override
    public int compare(Person member1, Person member2) {
        if (member1 != null && member2 != null) {
            return Integer.compare(member1.getDate(), member2.getDate());
        }
        return 1;
    }
}

