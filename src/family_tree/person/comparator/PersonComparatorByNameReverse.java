package family_tree.person.comparator;

import family_tree.person.Person;

import java.util.Comparator;

public class PersonComparatorByNameReverse implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o2.compareTo(o1);
    }
}
