package familyTree.comparators;

import person.Person;

import java.util.Comparator;

public class PersonComparatorByGender<E extends Person> implements Comparator<E> {
    @Override
    public int compare(E p1, E p2) {
        int result = p1.getGender().compareTo(p2.getGender());
        if (result == 0) result = p1.getFirstName().compareTo(p2.getFirstName());
        if (result == 0) result = p1.getLastName().compareTo(p2.getLastName());
        if (result == 0) {
            result = p1.getBornDate().compareTo(p2.getBornDate());
        }
        return result;
    }
}