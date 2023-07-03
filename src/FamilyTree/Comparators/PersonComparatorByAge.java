package FamilyTree.Comparators;

import java.util.Comparator;

import FamilyTree.Person;

public class PersonComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getDateBirth().compareTo(o2.getDateBirth());
    }

}
