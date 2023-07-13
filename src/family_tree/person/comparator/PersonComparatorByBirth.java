package family_tree.person.comparator;

import family_tree.person.Person;

import java.util.Comparator;

public class PersonComparatorByBirth implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getBirthDate().split(" ")[2].compareTo(o2.getBirthDate().split(" ")[2]);
    }
}