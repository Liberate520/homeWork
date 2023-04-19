package Tree.Comporators;
import java.util.Comparator;

import Tree.Person;

public class ComparByName<E extends Person> implements Comparator<E>{
    @Override
    public int compare(E person1, E person2) {
        return person1.getFirstName().compareTo(person2.getFirstName());
    }
}
