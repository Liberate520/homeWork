package tree.comporator;
import java.util.Comparator;

import tree.person.Person;

public class PersonComparatorById implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getId(), o2.getId());

    }
}