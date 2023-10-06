package people.comparators;

import people.Person;

import java.util.Comparator;

public class PersonComparatorByBirthDate implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getBirthDate().getYear(), o2.getBirthDate().getYear());
    }

}
