package Tree.Comparators;

import Human.Human;

import java.util.Comparator;

public class humanComparatorByAge<E extends Human> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getBirth_year(), o2.getBirth_year());
    }
}
