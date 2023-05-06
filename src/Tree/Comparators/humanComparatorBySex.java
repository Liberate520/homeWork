package Tree.Comparators;

import Human.Human;

import java.util.Comparator;

public class humanComparatorBySex<E extends Human> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getSex().compareTo(o2.getSex());
    }
}
