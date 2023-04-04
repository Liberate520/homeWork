package group.comparators;

import java.util.Comparator;

import person.Person;

public class PersonComparatorById implements Comparator<Person>{

    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getId(), p2.getId());
    }
}
