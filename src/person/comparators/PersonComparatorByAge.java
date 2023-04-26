package person.comparators;

import interfaces.Anthropoid;

import java.util.Comparator;

public class PersonComparatorByAge<E extends Anthropoid> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
