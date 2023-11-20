package FamilyTree.Person.comparators;

import FamilyTree.Person.PersonElements;

import java.util.Comparator;

public class CompareByPersonName<E extends PersonElements> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
