package tree.comporator;
import java.util.Comparator;

import tree.person.Person;

public class PersonComporatorByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}