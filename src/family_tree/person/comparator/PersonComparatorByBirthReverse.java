package family_tree.person.comparator;

import family_tree.person.Person;

import java.util.Comparator;

public class PersonComparatorByBirthReverse implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o2.getBirthDate().split(" ")[2].compareTo(o1.getBirthDate().split(" ")[2]);
    }
}
