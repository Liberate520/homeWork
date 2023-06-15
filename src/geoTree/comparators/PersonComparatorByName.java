package geoTree.comparators;
import java.util.Comparator;

import person.Person;

public class PersonComparatorByName implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
