package Human.comparators;
import java.util.Comparator;

import Human.Human;
import Tree.TreeCommon;

public class HumanComparatorByAge<E extends TreeCommon> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}