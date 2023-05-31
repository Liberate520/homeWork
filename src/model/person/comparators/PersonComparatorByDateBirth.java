package java_oop_homeWork.src.model.person.comparators;

import java_oop_homeWork.src.model.person.Person;

import java.util.Comparator;

public class PersonComparatorByDateBirth implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getDateBirth().compareTo(o2.getDateBirth());
    }
}
