package Tree.Comporators;
import java.util.Comparator;

import Tree.Person;

public class ComparByName implements Comparator<Person>{
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getFirstName().compareTo(person2.getFirstName());
    }
}
