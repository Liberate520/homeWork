package person;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getFullName().compareTo(p2.getFullName());
    }

}