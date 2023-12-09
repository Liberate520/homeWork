package familyTree;

import java.util.Comparator;

public class ComparatorByAge<E extends commonParam> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}