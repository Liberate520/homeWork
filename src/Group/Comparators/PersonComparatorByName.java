package Group.Comparators;

import java.util.Comparator;
import Person.Person;

public class PersonComparatorByName implements Comparator<Person>{
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
