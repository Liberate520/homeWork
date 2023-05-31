package java_oop_homeWork.src.model.person.comparators;

import java_oop_homeWork.src.model.person.Person;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
