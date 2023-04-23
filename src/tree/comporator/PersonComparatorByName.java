package tree.comporator;
import java.util.Comparator;

import tree.person.Person;

public class PersonComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastname().compareTo(o2.getLastname());
    }
}